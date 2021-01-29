package simetrico.conDoFinal;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	private static String  ENCRYPT_KEY="clave-coclave-co";
	// AES es una t�cnica de cifrado de clave sim�trica que remplazar� el Est�ndar de
	// Encriptaci�n de Datos (DES) utilizado habitualmente.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String encriptado = encript("Pues vamos a hacer una prueba");
			System.out.println("encriptado " + encriptado);
			
			String desencriptado = decrypt(encriptado);
			System.out.println("desencriptado " + desencriptado);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		 
	private static String encript(String text) throws Exception {  
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	 
	    byte[] encrypted = cipher.doFinal(text.getBytes());
	         
	    //return Base64.getEncoder().encode(encrypted);
	    return Base64.getEncoder().encodeToString(encrypted);
	}
	
	private static String decrypt(String encrypted) throws Exception {
		
	    byte[] encryptedBytes = Base64.getDecoder().decode(encrypted.replace("\n", ""));
	         
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, aesKey);
	 
	    String decrypted = new String(cipher.doFinal(encryptedBytes));
	         
	    return decrypted;
	    }


}
