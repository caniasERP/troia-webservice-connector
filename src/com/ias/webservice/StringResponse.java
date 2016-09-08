/**
 * StringResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
package com.ias.webservice;

public class StringResponse implements java.io.Serializable {

    private java.lang.String value;

    private boolean comressed;

    public StringResponse() {
    }

    public StringResponse(
            java.lang.String value,
            boolean comressed) {
        this.value = value;
        this.comressed = comressed;
    }

    /**
     * Gets the value value for this StringResponse.
     *
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value value for this StringResponse.
     *
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the comressed value for this StringResponse.
     *
     * @return comressed
     */
    public boolean isComressed() {
        return comressed;
    }

    /**
     * Sets the comressed value for this StringResponse.
     *
     * @param comressed
     */
    public void setComressed(boolean comressed) {
        this.comressed = comressed;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StringResponse)) {
            return false;
        }
        StringResponse other = (StringResponse) obj;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true
                && ((this.value == null && other.getValue() == null)
                || (this.value != null
                && this.value.equals(other.getValue())))
                && this.comressed == other.isComressed();
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
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        _hashCode += (isComressed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc
            = new org.apache.axis.description.TypeDesc(StringResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.ias.com", "StringResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comressed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Comressed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        return new org.apache.axis.encoding.ser.BeanSerializer(
                _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanDeserializer(
                _javaType, _xmlType, typeDesc);
    }

}
