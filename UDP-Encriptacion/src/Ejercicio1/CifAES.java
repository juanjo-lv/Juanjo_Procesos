package Ejercicio1;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class CifAES {
	public static final String ENCRYPT_KEY ="clave-coclave-co"; 

	//Algoritmo que convierte una cadena a AES

	public static String encript(String text) throws Exception {  
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	 
	    byte[] encrypted = cipher.doFinal(text.getBytes());
	         
	    //return Base64.getEncoder().encode(encrypted);
	    return Base64.getEncoder().encodeToString(encrypted);
	}
	public static String decrypt(String encrypted) throws Exception {
		
	    byte[] encryptedBytes = Base64.getDecoder().decode(encrypted.replace("\n", ""));
	         
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, aesKey);
	 
	    String decrypted = new String(cipher.doFinal(encryptedBytes));
	         
	    return decrypted;
	    }
	
}	