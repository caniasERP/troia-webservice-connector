package com.ias.webservice.connector.test;

import java.net.URL;

import com.ias.webservice.CaniasResponse;
import com.ias.webservice.CaniasWebService;
import com.ias.webservice.CaniasWebServiceServiceLocator;
import com.ias.webservice.LoginResponse;

public class TroiaWebServiceTesterConsole {

	public static void main(String[] args) {

		String strWSDLPath = "http://192.168.0.14:8080/CaniasWebService/services/CaniasWebService?WSDL";

		try {

			CaniasWebServiceServiceLocator iLocator = new CaniasWebServiceServiceLocator();

			CaniasWebService iService = iLocator.getCaniasWebService(new URL(strWSDLPath));
			
			LoginResponse iLogin = iService.login("00", "E", "CANIAS", "IAS604", "192.168.0.7/502", "btan", "1", false, false, "", "");

			
			String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>"; 
			//parameters = "<PARAMETERS><PARAM type=\"VECTOR\"><VECTOR><ITEM><NAME>N1</NAME><TYPE>STRING</TYPE><VALUE>N1VALUE</VALUE></ITEM><ITEM><NAME>N1</NAME><TYPE>STRING</TYPE><VALUE>N1VALUE</VALUE></ITEM></VECTOR></PARAM><PARAM type=\"TABLE\"><MYTABLE><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW></MYTABLE></PARAM></PARAMETERS>";
			//parameters = "<PARAMETERS><PARAM type=\"TABLE\"><MYTABLE><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW><ROW><COL1>col1val</COL1><COL2>col2val</COL2></ROW></MYTABLE></PARAM></PARAMETERS>";
			
			
			if (iLogin.isSuccess()) {

				
				CaniasResponse iResponse = iService.callService(iLogin.getSessionId(), iLogin.getSecurityKey(), "RDTEST", parameters, false, false, "", 1);
				
				System.out.println(iResponse.getResponse().getValue());	
				
				iService.logout(iLogin.getSessionId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
