/**
 * LoginResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ias.webservice;

public class LoginResponse  implements java.io.Serializable {
    private java.lang.String sessionId;

    private java.lang.String errorMessage;

    private java.lang.String contactNum;

    private java.lang.String encryptionKey;

    private boolean success;

    private java.lang.String securityKey;

    public LoginResponse() {
    }

    public LoginResponse(
           java.lang.String sessionId,
           java.lang.String errorMessage,
           java.lang.String contactNum,
           java.lang.String encryptionKey,
           boolean success,
           java.lang.String securityKey) {
           this.sessionId = sessionId;
           this.errorMessage = errorMessage;
           this.contactNum = contactNum;
           this.encryptionKey = encryptionKey;
           this.success = success;
           this.securityKey = securityKey;
    }


    /**
     * Gets the sessionId value for this LoginResponse.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this LoginResponse.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the errorMessage value for this LoginResponse.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this LoginResponse.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the contactNum value for this LoginResponse.
     * 
     * @return contactNum
     */
    public java.lang.String getContactNum() {
        return contactNum;
    }


    /**
     * Sets the contactNum value for this LoginResponse.
     * 
     * @param contactNum
     */
    public void setContactNum(java.lang.String contactNum) {
        this.contactNum = contactNum;
    }


    /**
     * Gets the encryptionKey value for this LoginResponse.
     * 
     * @return encryptionKey
     */
    public java.lang.String getEncryptionKey() {
        return encryptionKey;
    }


    /**
     * Sets the encryptionKey value for this LoginResponse.
     * 
     * @param encryptionKey
     */
    public void setEncryptionKey(java.lang.String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }


    /**
     * Gets the success value for this LoginResponse.
     * 
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }


    /**
     * Sets the success value for this LoginResponse.
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }


    /**
     * Gets the securityKey value for this LoginResponse.
     * 
     * @return securityKey
     */
    public java.lang.String getSecurityKey() {
        return securityKey;
    }


    /**
     * Sets the securityKey value for this LoginResponse.
     * 
     * @param securityKey
     */
    public void setSecurityKey(java.lang.String securityKey) {
        this.securityKey = securityKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginResponse)) return false;
        LoginResponse other = (LoginResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sessionId==null && other.getSessionId()==null) || 
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.contactNum==null && other.getContactNum()==null) || 
             (this.contactNum!=null &&
              this.contactNum.equals(other.getContactNum()))) &&
            ((this.encryptionKey==null && other.getEncryptionKey()==null) || 
             (this.encryptionKey!=null &&
              this.encryptionKey.equals(other.getEncryptionKey()))) &&
            this.success == other.isSuccess() &&
            ((this.securityKey==null && other.getSecurityKey()==null) || 
             (this.securityKey!=null &&
              this.securityKey.equals(other.getSecurityKey())));
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
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getContactNum() != null) {
            _hashCode += getContactNum().hashCode();
        }
        if (getEncryptionKey() != null) {
            _hashCode += getEncryptionKey().hashCode();
        }
        _hashCode += (isSuccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSecurityKey() != null) {
            _hashCode += getSecurityKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "LoginResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ErrorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ContactNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptionKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EncryptionKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
