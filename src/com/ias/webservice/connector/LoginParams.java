package com.ias.webservice.connector;

/**
 * TROIA Web Service Tester
 *
 * @author Bahtiyar Tan
 * @version 2.0
 * @date 2016/08/25 between 2016/07/19
 */
public class LoginParams {

    public String strWSURL, strClient, strLanguage, strDBServer, strDBName, strAPServer, strUsername, strPasswordField;
    public Boolean IsEncrypted, IsCompressed;
    public String strLCheck, strVKey;

    /**
     *
     * @param pClient holds name of the user.
     * @param pLanguage holds selected language.
     * @param pDBServer holds name of the Database Server.
     * @param pDBName holds name of Database.
     * @param pAPServer holds address of Application Server.
     * @param pUsername holds user's username.
     * @param pPasswordField holds user's password.
     * @param pIsEncrypted holds Encrypted flag.
     * @param pIsCompressed holds Compressed flag.
     * @param pLCheck holds LCheck paramater. It is used internally; it is
     * passed an empty string as LCheck parameter by client application.
     * @param pVKey holds VKey paramater. It is used internally; it is passed an
     * empty string as LCheck parameter by client application.
     *
     */
    public LoginParams(String pClient, String pLanguage, String pDBServer, String pDBName, String pAPServer, String pUsername, String pPasswordField, Boolean pIsEncrypted, Boolean pIsCompressed, String pLCheck, String pVKey) {
        this.strClient = pClient;
        this.strLanguage = pLanguage;
        this.strDBServer = pDBServer;
        this.strDBName = pDBName;
        this.strAPServer = pAPServer;
        this.strUsername = pUsername;
        this.strPasswordField = pPasswordField;
        this.IsEncrypted = pIsEncrypted;
        this.IsCompressed = pIsCompressed;
        this.strLCheck = pLCheck;
        this.strVKey = pVKey;
    }

}
