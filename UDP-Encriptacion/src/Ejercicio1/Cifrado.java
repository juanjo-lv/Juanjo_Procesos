package Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Cifrado {
	
	
	public static void encriptarMensaje(String mensaje) {
		Cipher encriptador = null;
		String inicio = "mensaje_cifrado.txt";
		String destino = "mensaje";
		BufferedWriter bw =null;
		try {
			bw = new BufferedWriter(new FileWriter(inicio));
			bw.write(mensaje);
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			encriptador = Cipher.getInstance("DES/ECB/PKCS5Padding");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//clave de encriptación
		String strclave = "M0Kkxp71";
	
		SecretKeySpec clave = new SecretKeySpec(strclave.getBytes(),"DES");
		
		try {
			encriptador.init(Cipher.ENCRYPT_MODE,clave);
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		CipherOutputStream streamEncriptado=null;
		
		try {
			FileInputStream fichEntrada = new FileInputStream(inicio);
			FileOutputStream fichSalida = new FileOutputStream(destino);
			
			streamEncriptado = new CipherOutputStream( fichSalida ,encriptador);
			byte[] buffer = new byte[1024];
			int numbytes=0;
			
			while((numbytes = fichEntrada.read(buffer))!=-1) {
				streamEncriptado.write(buffer,0,numbytes);
			}
			streamEncriptado.close();
			fichEntrada.close();
			fichSalida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
			
	}
	public static void desencriptarMensaje() {
		String entrada = "mensaje";
		String salida = "mensaje_cifrado";
		
		Cipher encriptador = null;
		
		try {
			encriptador = Cipher.getInstance("DES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		String strclave = "M0Kkxp71";
		SecretKeySpec clave = new SecretKeySpec(strclave.getBytes(),"DES");
		
		try {
			encriptador.init(Cipher.DECRYPT_MODE, clave);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fichEntrada=null;
		try {
			fichEntrada = new FileInputStream(entrada);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fichSalida = null;
		try {
			fichSalida = new FileOutputStream(salida);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CipherInputStream streamDesencriptado;
		streamDesencriptado = new CipherInputStream(fichEntrada,encriptador);
		
		byte[] buffer = new byte[1024];
		int nbytes=0;
		try {
			while((nbytes= streamDesencriptado.read(buffer))!=-1){
				fichSalida.write(buffer,0,nbytes);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			streamDesencriptado.close();
			fichSalida.close();
			fichEntrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
		
}
