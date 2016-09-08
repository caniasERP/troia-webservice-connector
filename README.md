# troia-webservice-connector
A simpel java api to connect troia platform via web service 2.0

String strWSDLPath = "http://192.168.0.14:8080/CaniasWebService/services/CaniasWebService?WSDL";

		try {

			CaniasWebServiceServiceLocator iLocator = new CaniasWebServiceServiceLocator();

			CaniasWebService iService = iLocator.getCaniasWebService(new URL(strWSDLPath));
			
			LoginResponse iLogin = iService.login("00", "E", "CANIAS", "IAS604", "192.168.0.7/502", "btan", "XXXX", false, false, "", "");

			
			String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>"; 
			
			
			if (iLogin.isSuccess()) {

				
				CaniasResponse iResponse = iService.callService(iLogin.getSessionId(), iLogin.getSecurityKey(), "RDTEST", parameters, false, false, "", 1);
				
				System.out.println(iResponse.getResponse().getValue());	
				
				iService.logout(iLogin.getSessionId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
