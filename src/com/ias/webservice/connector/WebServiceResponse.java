package com.ias.webservice.connector;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.ws.security.WSSecurityException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ias.webservice.CaniasResponse;

/**
 * 
 * 
 * @author BAHTIYAR
 */
public final class WebServiceResponse {

	public final CaniasResponse iResponse;

	private TroiaMessage[] mMessages = null;
	private TroiaVariable[] mVariables = null;

	/**
	 * This constructor takes CanisResponse information and makes parsing
	 * process for XML responses with respect to their values.
	 *
	 * @param pCaniasResponse
	 * @throws WebServiceException
	 */
	public WebServiceResponse(CaniasResponse pCaniasResponse) {
		this.iResponse = pCaniasResponse;
	}

	/**
	 * Parsing Troia Messages.
	 *
	 * @param xmlText
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws WSSecurityException
	 * @throws GeneralSecurityException
	 * @throws WebServiceException
	 */
	private TroiaMessage[] parseMessages(String xmlText) throws WebServiceException {

		if (!"".equals(xmlText)) {

			try {
				DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = newDocumentBuilder.parse(new ByteArrayInputStream(xmlText.getBytes()));

				// Fields....
				NodeList items = document.getElementsByTagName(WebServiceConstants.Tags.Message.MESSAGE);

				TroiaMessage[] aMessages = new TroiaMessage[items.getLength()];

				for (int i = 0; i < items.getLength(); i++) {
					Element item = (Element) items.item(i);
					NodeList itemText = item.getElementsByTagName(WebServiceConstants.Tags.Message.TEXT);
					NodeList itemModule = item.getElementsByTagName(WebServiceConstants.Tags.Message.MODULE);
					NodeList itemType = item.getElementsByTagName(WebServiceConstants.Tags.Message.TYPE);
					NodeList itemNumber = item.getElementsByTagName(WebServiceConstants.Tags.Message.NUMBER);

					String strText = itemText.item(0).getTextContent();
					String strModule = itemModule.item(0).getTextContent();
					String strType = itemType.item(0).getTextContent();
					String strNumber = itemNumber.item(0).getTextContent();

					aMessages[i] = new TroiaMessage(strModule, strNumber, strText, strType);
				}

				return aMessages;

			} catch (Exception e) {
				throw new WebServiceException(e);
			}

		}

		// there is not any message
		return new TroiaMessage[0];
	}

	/**
	 * Parsing Troia Variables.
	 *
	 * @param xmlText
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws WebServiceException
	 */
	private TroiaVariable[] parseVariables(String xmlText) throws WebServiceException {

		if (!"".equals(xmlText)) {

			try {

				DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = newDocumentBuilder.parse(new ByteArrayInputStream(xmlText.getBytes()));

				NodeList items = document.getElementsByTagName(WebServiceConstants.Tags.Variable.VARIABLE);

				TroiaVariable[] aVariables = new TroiaVariable[items.getLength()];

				for (int i = 0; i < items.getLength(); i++) {
					Element item = (Element) items.item(i);

					NodeList itemName = item.getElementsByTagName(WebServiceConstants.Tags.Variable.NAME);
					NodeList itemType = item.getElementsByTagName(WebServiceConstants.Tags.Variable.TYPE);
					NodeList itemValue = item.getElementsByTagName(WebServiceConstants.Tags.Variable.VALUE);

					String strName = itemName.item(0).getTextContent();
					String strType = itemType.item(0).getTextContent();
					String strValue = itemValue.item(0).getTextContent();

					aVariables[i] = new TroiaVariable(strName, strValue, strType);
				}

				return aVariables;

			} catch (Exception e) {
				throw new WebServiceException(e);
			}

		}

		return new TroiaVariable[0];
	}

	/**
	 * All TROIA messages created while TROIA code is running are stored by
	 * application server and returned at Messages field of CaniasResponse.
	 * StringResponse complex type has two members. Value is requested string
	 * value. Compressed is a flag which shows whether value is compressed or
	 * not. If Compressed flag is set to false, Value filed stores return XML
	 * directly. Otherwise to get pure text, Value field must be decompressed.
	 *
	 * Messages string contains message text, module, message type and message
	 * number as XML format and these values are pointed out with final static
	 * variables.
	 *
	 * @return response Messages
	 */
	public TroiaMessage[] Messages() throws WebServiceException {

		if (mMessages == null) {
			this.mMessages = this.parseMessages(this.iResponse.getMessages().getValue());
		}

		return this.mMessages;
	}

	/**
	 * ExtraVariables member stores extra variables that are requested by the
	 * client application. StringResponse complex type has two members. Value is
	 * requested string value. Compressed is a flag which shows whether value is
	 * compressed or not. If Compressed flag is set to false, Value filed stores
	 * return XML directly. Otherwise to get pure text, Value field must be
	 * decompressed.
	 *
	 * Resulting value contains symbol name, symbol type and value as XML format
	 * and these values are pointed out with final static variables.
	 *
	 * @return response Variables
	 */
	public TroiaVariable[] Variables() throws WebServiceException {

		if (mVariables == null) {
			this.mVariables = this.parseVariables(this.iResponse.getExtraVariables().getValue());
		}

		return this.mVariables;
	}

	/**
	 * Web Service directly returns same value of callService() method’s
	 * RequestId parameter.
	 *
	 * @return response RequestId
	 */
	public int RequestId() {
		return this.iResponse.getRequestId();
	}

	/**
	 * This field stores the returning value of TROIA Class method, which is
	 * registered as WebService. StringResponse complex type has two members.
	 * Value is requested string value. Compressed is a flag which shows whether
	 * value is compressed or not. If Compressed flag is set to false, Value
	 * filed stores return XML directly. Otherwise to get pure text, Value field
	 * must be decompressed.
	 *
	 * If communication is an encrypted connection, StringResponse must be
	 * decrypted by client application.
	 *
	 * @return StringResponse
	 */
	public String getStringResponse() {
		return this.iResponse.getResponse().getValue();
	}

	/**
	 * Returns the value of SYS_STATUS system variable after service call.
	 * 
	 * @return
	 */
	public int getSYSStatus() {
		return this.iResponse.getSYSStatus();
	}

	/**
	 * Returns the value of SYS_STATUSERROR system variable after service call.
	 *
	 * @return response SYSStatusError
	 */
	public String getSYSStatusError() {
		return this.iResponse.getSYSStatusError();
	}
}
