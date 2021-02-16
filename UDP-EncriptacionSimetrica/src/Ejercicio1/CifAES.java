package Ejercicio1;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class CifAES {

	//Algoritmo que convierte una cadena a AES

	public static String encript(String text,String clave){  
	    Key aesKey = new SecretKeySpec(clave.getBytes(), "AES");
	 
	    Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			System.err.println("la clave introducida no es valida");
		}
	 
	    byte[] encrypted = null;
		try {
			encrypted = cipher.doFinal(text.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return Base64.getEncoder().encodeToString(encrypted);
	}
	public static String decrypt(String encrypted,String clave){
		
	    byte[] encryptedBytes = Base64.getDecoder().decode(encrypted.replace("\n", ""));
	         
	    Key aesKey = new SecretKeySpec(clave.getBytes(), "AES");
	 
	    Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    String decrypted = null;
		try {
			decrypted = new String(cipher.doFinal(encryptedBytes));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			System.err.println("Estás intentando descifrar con una clave incorrecta");
		}
	         
	    return decrypted;
	    }
	
}	