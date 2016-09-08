package com.ias.webservice.connector;

@SuppressWarnings("serial")
public class WebServiceException extends Exception {

	public WebServiceException(String pMessage, Exception pCause) {
		super(pMessage, pCause);
	}

	public WebServiceException(String pMessage) {
		super(pMessage);
	}

	public WebServiceException(Exception pCause) {
		super(pCause);
	}
}
