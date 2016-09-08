# troia-webservice-connector
A simple java api to connect troia platform via web service 2.0

#usage

String strWSDLUrl = "http://192.168.0.14:8080/CaniasWebService/services/CaniasWebService?WSDL";

WebServiceConnector iConnector = new WebServiceConnector(strWSDLUrl);
			

LoginParams iParams = new LoginParams("00", "E", "CANIAS", "IAS604", "192.168.0.7/502", "btan", "XXXX", false, false, "", "");

LoginResponse iLogin = iConnector.login(iParams);

if (iLogin.isSuccess()) {

	String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>"; 
	
	WebServiceResponse iResponse = iConnector.callService("RDTEST", parameters, false, false, "", 1);
	
	System.out.println(iResponse.getStringResponse());	
	
	iConnector.logOut();
}
