package com.ias.webservice.connector;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Vector;

import com.ias.webservice.CaniasResponse;
import com.ias.webservice.CaniasWebService;
import com.ias.webservice.CaniasWebServiceServiceLocator;
import com.ias.webservice.LoginResponse;

/**
 * TROIA Web Service Tester
 *
 * @author Bahtiyar Tan
 * @version 2.0
 * @date 2016/08/25 between 2016/07/19
 */
public class WebServiceConnector {

	public CaniasWebServiceServiceLocator iLocator = null;
	public CaniasWebService iService = null;
	public SessionInfo iSessionInfo = null;

	/**
	 * This constructor creates a WebService element for the system.
	 * 
	 * @param pURL
	 * @throws WebServiceException
	 */
	public WebServiceConnector(String pURL) throws WebServiceException {
		try {
			this.iLocator = new CaniasWebServiceServiceLocator();
			this.iService = iLocator.getCaniasWebService(new URL(pURL));
		} catch (Exception e) {
			throw new WebServiceException("error while locating service", e);
		}
	}

	/**
	 * This method is used for running a TROIA Class Method which is registered
	 * as a TROIA Web Service. Method has six input parameter. Detailed
	 * information about these input parameters are below:
	 *
	 * @param pServiceId
	 *            holds user's selected service. ServiceName, key value while
	 *            accessing all service information like service class, method
	 *            name and web service rights.If given ServiceId is not
	 *            registered, service call fails, and return value shows service
	 *            call’s failure message.
	 *
	 * @param pParameters
	 *            holds user's parameters. It gets CANIAS Web Services as XML
	 *            formatted string.
	 *
	 * @param pCompressed
	 *            indicates whether parameters are compressed or not. If
	 *            parameters are compressed true value must be passed, otherwise
	 *            false value must be passed.
	 *
	 * @param pPermanent
	 *            for each service call, application server opens a transaction
	 *            automatically and executes all TROIA codes in this
	 *            transaction. After procedure finished transaction is closed.
	 *            If the client application sends true as permanency option,
	 *            application server does not close transaction, and next
	 *            service codes are executed at same scope.
	 *
	 * @param pEVariables
	 *            holds user's extra variables.
	 * @param pRequestId
	 *            holds a number of each service call.
	 *
	 *            As its default behavior, system does not use encrypted
	 *            communication. If encrypted communication is needed due to
	 *            application's requirements, client applications must send true
	 *            value as encryption information on login request.
	 *            Additionally, for encrypted connections, client applications
	 *            must send Parameters string as an encrypted string. The way of
	 *            encryption must be same as the server side encryption process
	 *            and resulting value must be Base64 String.
	 *
	 * @return callService
	 * @throws com.ias.webservice.connector.WebServiceException
	 */
	public WebServiceResponse callService(String pServiceId, String pParameters, boolean pCompressed, boolean pPermanent, String pEVariables, int pRequestId)
			throws WebServiceException {

		if (iSessionInfo != null) {

			try {
				if (iSessionInfo.isEncryptedConnection()) {
					pParameters = TroiaWSCryptoUtils.encrypt(pParameters, this.iSessionInfo.getEncryptionKey());
				}
			} catch (Exception e) {
				throw new WebServiceException("error while encrypting parameters", e);
			}

			CaniasResponse response = null;
			try {
				String strSessionId = this.iSessionInfo.getSessionId();
				String strSecurityKey = this.iSessionInfo.getSecurityKey();

				response = iService.callService(strSessionId, strSecurityKey, pServiceId, pParameters, pCompressed, pPermanent, pEVariables, pRequestId);
			} catch (Exception ex) {
				throw new WebServiceException("error while calling service", ex);
			}

			try {
				if (this.iSessionInfo.isEncryptedConnection()) {
					response.getResponse().setValue(TroiaWSCryptoUtils.decrypt(response.getResponse().getValue(), iSessionInfo.getEncryptionKey()));
					response.getMessages().setValue(TroiaWSCryptoUtils.decrypt(response.getMessages().getValue(), iSessionInfo.getEncryptionKey()));
					response.getExtraVariables().setValue(TroiaWSCryptoUtils.decrypt(response.getExtraVariables().getValue(), iSessionInfo.getEncryptionKey()));
				}
			} catch (Exception ex) {
				throw new WebServiceException("error while decrypting service response", ex);
			}

			return new WebServiceResponse(response);

		} else {
			throw new WebServiceException("session info is null, please login before service call");
		}

	}

	/**
	 * This logins the system if user's login credentials is correct and creates
	 * a connector session on CANIAS Application Server.
	 *
	 * @param pParams
	 *            holding user's Login parameters.
	 * @return LoginResponse
	 * @throws com.ias.webservice.connector.WebServiceException
	 */
	public LoginResponse login(LoginParams pParams) throws WebServiceException {

		LoginResponse iResponse = null;

		try {
			iResponse = this.iService.login(pParams.strClient, pParams.strLanguage, pParams.strDBServer, pParams.strDBName, pParams.strAPServer,
					pParams.strUsername, pParams.strPasswordField, pParams.IsEncrypted, pParams.IsCompressed, pParams.strLCheck, pParams.strVKey);

			if (iResponse.isSuccess()) {
				this.iSessionInfo = new SessionInfo(iResponse.getSessionId(), iResponse.getSecurityKey(), iResponse.getContactNum(),
						iResponse.getEncryptionKey());
			}

		} catch (Exception e) {
			throw new WebServiceException("error while login", e);
		}

		return iResponse;
	}

	/**
	 * This gets SessionId parameter as string and removes the connector session
	 * which has given session id. Method returns true if the log out operation
	 * is successful.
	 * 
	 * @return
	 * @throws WebServiceException
	 */
	public boolean logOut() throws WebServiceException {

		if (this.iSessionInfo == null) {
			throw new WebServiceException("session info is null, please login before logout");
		} else {
			try {
				return iService.logout(this.iSessionInfo.getSessionId());
			} catch (Exception e) {
				throw new WebServiceException(e);
			}
		}
	}

	/**
	 * <p>
	 * This method makes an arraylist by taking TROIA web service's
	 * listServices() method. listServices() method of TROIA web service gets
	 * SessionId as string parameter and returns all available services as
	 * string array. Web Services which user has not permission to call are not
	 * included in returning an array.If returning array does not include the
	 * name of web service that you want to call, you must check whether your
	 * method is registered as web service and user who is connected as web
	 * service client has permission to run registered service.<br>
	 * <br>
	 *
	 * @return ArrayList (call function with an ArrayList to get serviceNames)
	 * @throws RemoteException
	 */
	public Vector<String> getServiceList() throws WebServiceException {

		try {
			Vector<String> vServiceList = new Vector<String>();
			int positionSeparator;
			for (String service : this.iService.listServices(this.iSessionInfo.getSessionId())) {
				positionSeparator = service.indexOf("_");
				vServiceList.add(service.substring(0, positionSeparator));
			}
			return vServiceList;
		} catch (Exception e) {
			throw new WebServiceException("error while listing services", e);
		}
	}

	/**
	 * This returns connecting session.
	 *
	 * @return SessionInfo
	 */
	public SessionInfo getSessionInfo() {
		return iSessionInfo;
	}

	/**
	 * This sets connecting session.
	 *
	 * @param SessionInfo
	 *            holding connector session parameters.
	 */
	public void setiSessionInfo(SessionInfo SessionInfo) {
		this.iSessionInfo = SessionInfo;
	}
}
