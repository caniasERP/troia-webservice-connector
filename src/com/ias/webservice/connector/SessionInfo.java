package com.ias.webservice.connector;

public class SessionInfo {

	private String sessionId;
	private String securityKey;
	private String contactNum;
	private String encriptionKey;

	/**
	 *
	 * @param sessionId
	 *            holds user's Session id
	 * @param securityKey
	 *            holds user's Security key.
	 * @param contactNum
	 *            holds user's Contact number.
	 * @param encriptionKey
	 *            holds user's encriypt key.
	 */
	public SessionInfo(String pSessionId, String pSecurityKey, String pContactNum, String pEncriptKey) {
		this.sessionId = pSessionId;
		this.securityKey = pSecurityKey;
		this.contactNum = pContactNum;
		this.encriptionKey = pEncriptKey;
	}

	/**
	 * This member returns user’s session id, otherwise. If login fails it is
	 * an empty string.
	 *
	 * @return SessionId
	 */
	public String getSessionId() {
		return this.sessionId;
	}

	/**
	 * Application Server returns a random security key for each successful
	 * login. Client application must pass this security key parameter while
	 * calling callService () method, to indicate it is an authenticated
	 * application.
	 *
	 * @return SecurityKey
	 */
	public String getSecurityKey() {
		return this.securityKey;
	}

	/**
	 * This member returns users ContactNum which is stored in CONTACTNUM column
	 * of IASUSERS table.
	 *
	 * @return ContactNum
	 */
	public String getContactNum() {
		return this.contactNum;
	}

	/**
	 * If client application connects an encrypted connection, application
	 * server returns an EncryptionKey which will be used at service
	 * interactions. Client application must convert EncryptionKey to a byte
	 * array using UTF8 encoding before using this key as an encryption key.
	 *
	 * @return EncriptKey
	 */
	public String getEncryptionKey() {
		return this.encriptionKey;
	}

	/**
	 * It returns encrypted connection state.
	 *
	 * @return IsEncryptedConnection
	 */
	public Boolean isEncryptedConnection() {
		return (this.encriptionKey.length() > 0);
	}

}
