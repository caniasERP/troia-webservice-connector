package com.ias.webservice.connector;

public class TroiaMessage {

	private String Module;
	private String Number;
	private String Text;
	private String Type;

	/**
	 * No access modifier, intentionally. to avoid creating messages from
	 * outside the package.
	 * 
	 * @param pModule
	 * @param pNumber
	 * @param pText
	 * @param pType
	 */
	public TroiaMessage(String pModule, String pNumber, String pText, String pType) {
		this.Module = pModule;
		this.Number = pNumber;
		this.Text = pText;
		this.Type = pType;
	}

	public String getModule() {
		return Module;
	}

	public String getNumber() {
		return Number;
	}

	public String getText() {
		return Text;
	}

	public String getType() {
		return Type;
	}

}
