package com.ias.webservice.connector;

/**
 * TROIA Web Service Tester
 *
 * @author Bahtiyar Tan
 * @version 2.0
 * @date 2016/08/25 between 2016/07/19
 */
/**
 *
 * This class represents Trovia Variable for RDTest services. Every variable
 * holds an element value from XML file. Name, Value and type.
 *
 */
public class TroiaVariable {

	private String Name;
	private String Value;
	private String Type;

	public TroiaVariable(String pName, String pValue, String pType) {
		this.Name = pName;
		this.Value = pValue;
		this.Type = pType;
	}

	public String getName() {
		return Name;
	}

	public String getValue() {
		return Value;
	}

	public String getType() {
		return Type;
	}
}
