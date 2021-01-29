package simetrico.conStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Programa que recibe el nombre de un fichero y lo encripta usando
 * DES sobre un fichero nuevo cuyo nombre se recibe como segundo
 * parametro.
 * 
 * La contrasenia de encriptacion esta, por comodidad, cableada en el
 * codigo fuente.
 * 
 */
public class Encriptar {

	/**
	 * Programa principal.
	 * 
	 * @param args Argumentos de la aplicacion. El primero es el fichero
	 * fuente y el segundo el destino.
	 */
	public static void main(String[] args) {
		final int TAM = 4096;
		String nombreFuente, nombreDestino;

		if (args.length < 2) {
			System.err.println("Especifica el nombre del fichero fuente y el destino");
			return;
		}
		
		nombreFuente = args[0];
		nombreDestino = args[1];
		
		// Obtenemos el proveedor de encriptacion/desencriptacion
		// que implemente el algoritmo DES.
		
		Cipher encriptador;
		
		try {
			// Solicitamos una implementacion del algoritmo DES, que
			// funcione en modo ECB (Electronic Code Book Mode) y
			// y el estandar de padding PKCS5. Bastaria con poner
			// DES y se usaria el modo y padding predefinido del
			// proveedor que escoja el sistema.
			encriptador = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// Clave sim�trica: 
		} catch (NoSuchAlgorithmException e) {
			System.err.println("No tienes ningun proveedor de DES");
			return;
		} catch (NoSuchPaddingException e) {
			System.err.println("No se soporta el padding PKCS5");
			return;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return;
		}

		// Ya tenemos la implementacion del algoritmo. Tenemos que
		// inicializarlo en modo "encriptar" y con una clave
		// (simetrica). Construimos la clave, cableandola en codigo.
		
		String strClave = "M1Cl@v3!";
		SecretKeySpec clave = new SecretKeySpec(strClave.getBytes(), "DES");
		
		try {
			encriptador.init(Cipher.ENCRYPT_MODE, clave);
			// Lo inicializamos para encriptar
		} catch (InvalidKeyException e) {
			// La clave no es correcta (longitud erronea, por ejemplo).
			System.err.println("Clave incorrecta: " + e.getLocalizedMessage());
			return;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return;			
		}
		
		// Abrimos el fichero fuente (en modo binario)
		FileInputStream fichEntrada = null;
		try {
			fichEntrada = new FileInputStream(nombreFuente);
		} catch (FileNotFoundException e) {
			System.err.println("No se pudo acceder al fichero " + nombreFuente);
			return;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return;
		}
		
		// Creamos el fichero destino (tambien en modo binario).
		// No escribiremos en este stream directamente.
		FileOutputStream fichSalida = null;
		try {
			fichSalida = new FileOutputStream(nombreDestino);
		} catch (FileNotFoundException e) {
			System.err.println("No se pudo crear el fichero " + nombreDestino);	
			try {
				fichEntrada.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			try {
				fichEntrada.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		} 
		
		// Envolvemos el stream de bytes del fichero de salida en un stream que
		// encripte antes.
		CipherOutputStream streamEncriptado;
		streamEncriptado = new CipherOutputStream(fichSalida, encriptador);
		
		// Leemos todo el contenido del fichero y lo enviamos al
		// stream de salida. El encriptador lo codificara y lo enviara
		// al stream del FileOutputStream.
		byte[] buffer = new byte[TAM];
		int noOfBytes = 0;
		try {
			while( (noOfBytes = fichEntrada.read(buffer)) != -1)
				streamEncriptado.write(buffer, 0, noOfBytes);
		}
		catch (IOException e) {
			System.err.println("Error durante la encriptacion: " + e.getLocalizedMessage());
		}
		try {
			streamEncriptado.close();
			fichEntrada.close();
			fichSalida.close();
		}
		catch (IOException ioe) {
		}

	} // main

} // Encriptar
