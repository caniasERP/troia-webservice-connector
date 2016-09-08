/**
 * CaniasWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ias.webservice;

public interface CaniasWebService extends java.rmi.Remote {
    public com.ias.webservice.LoginResponse login(java.lang.String client, java.lang.String language, java.lang.String DBServer, java.lang.String DBName, java.lang.String applicationServer, java.lang.String username, java.lang.String password, boolean encrypted, boolean compression, java.lang.String LCheck, java.lang.String VKey) throws java.rmi.RemoteException;
    public boolean logout(java.lang.String sessionId) throws java.rmi.RemoteException;
    public com.ias.webservice.CaniasResponse callService(java.lang.String sessionId, java.lang.String securityKey, java.lang.String serviceId, java.lang.String parameters, boolean compressed, boolean permanent, java.lang.String extraVariables, int requestId) throws java.rmi.RemoteException;
    public java.lang.String[] listServices(java.lang.String sessionId) throws java.rmi.RemoteException;
}
