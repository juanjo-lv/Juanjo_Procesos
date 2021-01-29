package encriptar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encriptar {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int TAM = 4096;
		String nombreFuente, nombreDestino;
		
		if(args.length<2) {
			System.err.println("Especifica el nombre del fichero fuente y el destino");
			return;
		}
		nombreFuente = args[0];
		nombreDestino = args[1];
		
		Cipher encriptador;
		
		try {
			encriptador = Cipher.getInstance("DES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			System.err.println("No tienes proveedor o no soporta PKCS5");
			return;
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		String strClave = "M1Cl@v3";
		SecretKeySpec clave = new SecretKeySpec(strClave.getBytes(),"DES");
		
		try {
			encriptador.init(Cipher.ENCRYPT_MODE, clave);
			//Lo inicializamos para encriptar
		} catch (InvalidKeyException e) {
			System.err.println("Clave incorrecta:"+e.getLocalizedMessage());
			return;
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		FileInputStream fichEntrada = null;
		try {
			fichEntrada = new FileInputStream(nombreFuente);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		FileOutputStream fichSalida = null;
		try {
			fichSalida = new FileOutputStream(nombreDestino);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		
	}

}
