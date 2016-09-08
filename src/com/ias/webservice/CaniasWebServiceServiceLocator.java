/**
 * CaniasWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ias.webservice;

public class CaniasWebServiceServiceLocator extends org.apache.axis.client.Service implements com.ias.webservice.CaniasWebServiceService {

    public CaniasWebServiceServiceLocator() {
    }


    public CaniasWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaniasWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaniasWebService
    private java.lang.String CaniasWebService_address = "http://www.ias.com.tr:8080/CaniasWebService/services/CaniasWebService";

    public java.lang.String getCaniasWebServiceAddress() {
        return CaniasWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaniasWebServiceWSDDServiceName = "CaniasWebService";

    public java.lang.String getCaniasWebServiceWSDDServiceName() {
        return CaniasWebServiceWSDDServiceName;
    }

    public void setCaniasWebServiceWSDDServiceName(java.lang.String name) {
        CaniasWebServiceWSDDServiceName = name;
    }

    public com.ias.webservice.CaniasWebService getCaniasWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CaniasWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaniasWebService(endpoint);
    }

    public com.ias.webservice.CaniasWebService getCaniasWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ias.webservice.CaniasWebServiceSoapBindingStub _stub = new com.ias.webservice.CaniasWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCaniasWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaniasWebServiceEndpointAddress(java.lang.String address) {
        CaniasWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ias.webservice.CaniasWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ias.webservice.CaniasWebServiceSoapBindingStub _stub = new com.ias.webservice.CaniasWebServiceSoapBindingStub(new java.net.URL(CaniasWebService_address), this);
                _stub.setPortName(getCaniasWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CaniasWebService".equals(inputPortName)) {
            return getCaniasWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.ias.com", "CaniasWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.ias.com", "CaniasWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CaniasWebService".equals(portName)) {
            setCaniasWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
