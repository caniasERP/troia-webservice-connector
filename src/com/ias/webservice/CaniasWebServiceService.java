/**
 * CaniasWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ias.webservice;

public interface CaniasWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getCaniasWebServiceAddress();

    public com.ias.webservice.CaniasWebService getCaniasWebService() throws javax.xml.rpc.ServiceException;

    public com.ias.webservice.CaniasWebService getCaniasWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
