package com.ias.webservice.connector.test;

import com.ias.webservice.LoginResponse;
import com.ias.webservice.connector.LoginParams;
import com.ias.webservice.connector.WebServiceConnector;
import com.ias.webservice.connector.WebServiceResponse;

public class TroiaWebServiceTesterConsole {

	public static void main(String[] args) {

		String strWSDLPath = "http://192.168.0.14:8080/CaniasWebService/services/CaniasWebService?WSDL";

		try {

			WebServiceConnector iConnector = new WebServiceConnector(strWSDLPath);
			

			LoginParams iParams = new LoginParams("00", "E", "CANIAS", "IAS604", "192.168.0.7/502", "btan", "XXXX", false, false, "", "");

			LoginResponse iLogin = iConnector.login(iParams);
			
			if (iLogin.isSuccess()) {

				String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>"; 
				
				WebServiceResponse iResponse = iConnector.callService("RDTEST", parameters, false, false, "", 1);
				
				System.out.println(iResponse.getStringResponse());	
				
				iConnector.logOut();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
