# troia-webservice-connector
A simple java api to connect troia platform via web service 2.0. Also contains a web service testing tool which has a swing gui, to run this testing tool double click binar\troia-web-service-connector-x.x.x.jar file.

#usage

	String strWSDLUrl = "http://192.168.0.14:8080/CaniasWebService/services/CaniasWebService?WSDL";

	WebServiceConnector iConnector = new WebServiceConnector(strWSDLUrl);
				
	LoginParams params = new LoginParams("00", "E", "LOCAL", "I604", "192.168.0.7/S1", "btan", "X", false, false, "", "");
	LoginResponse iLogin = iConnector.login(params);

	if (iLogin.isSuccess()) {

		String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>"; 
		
		WebServiceResponse iResponse = iConnector.callService("RDTEST", parameters, false, false, "", 1);
		
		System.out.println(iResponse.getStringResponse());	
		
		iConnector.logOut();
	}
