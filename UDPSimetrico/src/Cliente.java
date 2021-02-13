import java.io.*;
import java.net.*;
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

public class Cliente {

	private static String  ENCRYPT_KEY="Cl@v3-435-EjErC1";
	final static int MAX_LEN = 1024;

	public static void main(String[] args) {

		final String DIRECCION = "localhost";
		final int PUERTO = 55557;

		DatagramSocket socket = null;
		InetAddress direccion;

		byte[] mensajeSaliente = null;
		byte[] mensajeEntrante = null;

		String mensajeEnviado="";
		String mensajeRecibido = "";

		DatagramPacket paqueteEnviado = null;
		DatagramPacket paqueteRecibido = null;

		try {

			socket = new DatagramSocket();

			direccion = InetAddress.getByName(DIRECCION);

			mensajeEnviado = encriptar("Mensaje al servidor: tengo una consulta");
			mensajeSaliente = mensajeEnviado.getBytes();

			paqueteEnviado = new DatagramPacket(mensajeSaliente,mensajeEnviado.length(),direccion,PUERTO);

			socket.send(paqueteEnviado);

			mensajeEntrante = new byte[MAX_LEN];

			paqueteRecibido = new DatagramPacket(mensajeEntrante,mensajeEntrante.length);
			socket.receive(paqueteRecibido);

			//Nombre
			mensajeRecibido = desencriptar(new String(mensajeEntrante).trim());
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//DNI
			mensajeRecibido = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//Salario
			mensajeRecibido = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//Ultimo mes trabajado
			mensajeRecibido = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//Dias trabajados
			mensajeRecibido = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//Antigüedad
			mensajeRecibido = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);
			enviarMensaje(mensajeEnviado,mensajeRecibido, mensajeSaliente, paqueteEnviado, direccion, PUERTO, socket,mensajeRecibido);
			
			//Total
			JOptionPane.showMessageDialog(null, recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido));
			
			
		}catch(IOException e) {
			System.err.println(e);
		}catch(NoSuchAlgorithmException e){
			System.err.println(e);
		}catch(NoSuchPaddingException e) {
			System.err.println(e);
		}catch(InvalidKeyException e) {
			System.err.println(e);
		}catch(BadPaddingException e) {
			System.err.println(e);
		}catch(IllegalBlockSizeException e) {
			System.err.println(e);
		}finally {
			socket.close();
		}

	}

	public static void enviarMensaje(String mensajeEnviado, String mensajeParaElServidor, byte[] mensajeSaliente, DatagramPacket paqueteEnviado, 
			InetAddress direccion, int puerto, DatagramSocket socket, String mensajeRecibido){

		try {
			
			mensajeEnviado = "";
			mensajeEnviado = encriptar(JOptionPane.showInputDialog(mensajeRecibido));
			mensajeSaliente = mensajeEnviado.getBytes();

			paqueteEnviado = new DatagramPacket(mensajeSaliente,mensajeEnviado.length(),direccion,puerto);
			socket.send(paqueteEnviado);
			
		}catch(IOException e) {
			System.err.println(e);
		}catch(NoSuchAlgorithmException e){
			System.err.println(e);
		}catch(NoSuchPaddingException e) {
			System.err.println(e);
		}catch(InvalidKeyException e) {
			System.err.println(e);
		}catch(BadPaddingException e) {
			System.err.println(e);
		}catch(IllegalBlockSizeException e) {
			System.err.println(e);
		}
	}

	public static String recibirMensaje(byte[] mensajeEntrante, DatagramPacket paqueteRecibido, DatagramSocket socket, String mensajeRecibido) {
		
		try {
			mensajeEntrante = new byte[MAX_LEN];

			paqueteRecibido = new DatagramPacket(mensajeEntrante,mensajeEntrante.length);
			socket.receive(paqueteRecibido);

			mensajeRecibido = desencriptar(new String(mensajeEntrante).trim());	
			
		}catch(IOException e) {
			System.err.println(e);
		}catch(NoSuchAlgorithmException e){
			System.err.println(e);
		}catch(NoSuchPaddingException e) {
			System.err.println(e);
		}catch(InvalidKeyException e) {
			System.err.println(e);
		}catch(BadPaddingException e) {
			System.err.println(e);
		}catch(IllegalBlockSizeException e) {
			System.err.println(e);
		}
		
		return mensajeRecibido;
	}

	private static String encriptar(String texto) throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, BadPaddingException, IllegalBlockSizeException{  
		//Obtenemos una clave secreta pasando la clave a un array de bytes y especificando el algoritmo de cifrado, en este caso AES
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		//Devuelve un objeto de tipo Cipher que implementa la transformacion AES
		Cipher cipher = Cipher.getInstance("AES");

		//Iniciamos el cipher en modo encriptador con la clave obtenido al principio del metodo
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);

		//Encriptamos el texto pasado a un array de bytes
		byte[] encriptado = cipher.doFinal(texto.getBytes());

		//Retorna un String que ha sido codificado en Base64
		return Base64.getEncoder().encodeToString(encriptado);

	}

	private static String desencriptar(String encriptado) throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, BadPaddingException, IllegalBlockSizeException{

		//Obtenemos un array de bytes de la decodificacion, sustituyendo los saltos de linea
		byte[] encripBytes = Base64.getDecoder().decode(encriptado.replace("\n", ""));

		//Obtenemos una clave secreta pasando la clave a un array de bytes y especificando el algoritmo de cifrado, en este caso AES
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		//Devuelve un objeto de tipo Cipher que implementa la transformacion AES
		Cipher cipher = Cipher.getInstance("AES");
		//Iniciamos el cipher en modo desencriptador con la clave obtenido anteriormente
		cipher.init(Cipher.DECRYPT_MODE, aesKey);

		//Obtenemos un String que ha sido desencriptado, finalmente lo retornamos
		String desencriptado = new String(cipher.doFinal(encripBytes));

		return desencriptado;
	}

}
