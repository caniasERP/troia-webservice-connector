/**
 * CaniasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ias.webservice;

public class CaniasResponse  implements java.io.Serializable {
    private com.ias.webservice.StringResponse response;

    private com.ias.webservice.StringResponse extraVariables;

    private com.ias.webservice.StringResponse messages;

    private int SYSStatus;

    private java.lang.String SYSStatusError;

    private int requestId;

    public CaniasResponse() {
    }

    public CaniasResponse(
           com.ias.webservice.StringResponse response,
           com.ias.webservice.StringResponse extraVariables,
           com.ias.webservice.StringResponse messages,
           int SYSStatus,
           java.lang.String SYSStatusError,
           int requestId) {
           this.response = response;
           this.extraVariables = extraVariables;
           this.messages = messages;
           this.SYSStatus = SYSStatus;
           this.SYSStatusError = SYSStatusError;
           this.requestId = requestId;
    }


    /**
     * Gets the response value for this CaniasResponse.
     * 
     * @return response
     */
    public com.ias.webservice.StringResponse getResponse() {
        return response;
    }


    /**
     * Sets the response value for this CaniasResponse.
     * 
     * @param response
     */
    public void setResponse(com.ias.webservice.StringResponse response) {
        this.response = response;
    }


    /**
     * Gets the extraVariables value for this CaniasResponse.
     * 
     * @return extraVariables
     */
    public com.ias.webservice.StringResponse getExtraVariables() {
        return extraVariables;
    }


    /**
     * Sets the extraVariables value for this CaniasResponse.
     * 
     * @param extraVariables
     */
    public void setExtraVariables(com.ias.webservice.StringResponse extraVariables) {
        this.extraVariables = extraVariables;
    }


    /**
     * Gets the messages value for this CaniasResponse.
     * 
     * @return messages
     */
    public com.ias.webservice.StringResponse getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this CaniasResponse.
     * 
     * @param messages
     */
    public void setMessages(com.ias.webservice.StringResponse messages) {
        this.messages = messages;
    }


    /**
     * Gets the SYSStatus value for this CaniasResponse.
     * 
     * @return SYSStatus
     */
    public int getSYSStatus() {
        return SYSStatus;
    }


    /**
     * Sets the SYSStatus value for this CaniasResponse.
     * 
     * @param SYSStatus
     */
    public void setSYSStatus(int SYSStatus) {
        this.SYSStatus = SYSStatus;
    }


    /**
     * Gets the SYSStatusError value for this CaniasResponse.
     * 
     * @return SYSStatusError
     */
    public java.lang.String getSYSStatusError() {
        return SYSStatusError;
    }


    /**
     * Sets the SYSStatusError value for this CaniasResponse.
     * 
     * @param SYSStatusError
     */
    public void setSYSStatusError(java.lang.String SYSStatusError) {
        this.SYSStatusError = SYSStatusError;
    }


    /**
     * Gets the requestId value for this CaniasResponse.
     * 
     * @return requestId
     */
    public int getRequestId() {
        return requestId;
    }


    /**
     * Sets the requestId value for this CaniasResponse.
     * 
     * @param requestId
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaniasResponse)) return false;
        CaniasResponse other = (CaniasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            ((this.extraVariables==null && other.getExtraVariables()==null) || 
             (this.extraVariables!=null &&
              this.extraVariables.equals(other.getExtraVariables()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              this.messages.equals(other.getMessages()))) &&
            this.SYSStatus == other.getSYSStatus() &&
            ((this.SYSStatusError==null && other.getSYSStatusError()==null) || 
             (this.SYSStatusError!=null &&
              this.SYSStatusError.equals(other.getSYSStatusError()))) &&
            this.requestId == other.getRequestId();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        if (getExtraVariables() != null) {
            _hashCode += getExtraVariables().hashCode();
        }
        if (getMessages() != null) {
            _hashCode += getMessages().hashCode();
        }
        _hashCode += getSYSStatus();
        if (getSYSStatusError() != null) {
            _hashCode += getSYSStatusError().hashCode();
        }
        _hashCode += getRequestId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaniasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "CaniasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "StringResponse"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extraVariables");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ExtraVariables"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "StringResponse"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "StringResponse"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SYSStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SYSStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SYSStatusError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SYSStatusError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RequestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
