package com.ias.webservice.connector;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.ws.security.util.Base64;

public class TroiaWSCryptoUtils {

	/**
	 * Taking the user targer charset parameter to encode.
	 */
	public static String targetCharsetParam = "UTF-8";
	private final static String characterEncoding = targetCharsetParam;
	private final static String cipherTransformation = "AES/CBC/PKCS5Padding";
	private final static String aesEncryptionAlgorithm = "AES";

	public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws Exception {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
		cipherText = cipher.doFinal(cipherText);
		return cipherText;
	}

	public static byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector) throws Exception {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		plainText = cipher.doFinal(plainText);
		return plainText;
	}

	private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
		byte[] keyBytes = new byte[16];
		byte[] parameterKeyBytes = key.getBytes(characterEncoding);
		System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
		return keyBytes;
	}

	/**
	 * Encrypts plaintext using AES 128bit key and a Chain Block Cipher and
	 * returns a base64 encoded string
	 * 
	 * @param plainText
	 *            Plain text to encrypt
	 * @param key
	 *            Secret key
	 * @return Base64 encoded string
	 * @throws Exception
	 */
	public static String encrypt(String plainText, String key) throws Exception {
		byte[] plainTextbytes = plainText.getBytes(characterEncoding);
		byte[] keyBytes = getKeyBytes(key);

		return Base64.encode(encrypt(plainTextbytes, keyBytes, keyBytes));
		// return Base64.encodeToString(encrypt(plainTextbytes,keyBytes,
		// keyBytes), Base64.DEFAULT);
	}

	/**
	 * Decrypts a base64 encoded string using the given key (AES 128bit key and
	 * a Chain Block Cipher)
	 * 
	 * @param encryptedText
	 *            Base64Encoded String
	 * @param Secret
	 *            key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptedText, String key) throws Exception {
		byte[] cipheredBytes = Base64.decode(encryptedText);
		byte[] keyBytes = getKeyBytes(key);
		return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
	}
}
