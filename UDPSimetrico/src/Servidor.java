import java.io.*;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Servidor {

	private static String  ENCRYPT_KEY="Cl@v3-435-EjErC1";
	final static int MAX_LEN = 1024;

	public static void main(String[] args) {

		final int PUERTO = 55557;

		DatagramSocket socket = null;

		try {

			byte[] mensajeEntrante;

			String mensajeRecibido;

			socket = new DatagramSocket(PUERTO);

			int contClientes = 1;

			while(true) {
				//Limiamos el buffer
				mensajeEntrante = new byte[MAX_LEN];

				//Preparamos el paquete donde queremos recibir el mensaje del cliente
				DatagramPacket paqueteRecibido = new DatagramPacket(mensajeEntrante,mensajeEntrante.length);

				System.out.println("***Servidor esperando***");

				//Esperamos hasta que recibamos el paquete
				socket.receive(paqueteRecibido);
				System.out.println("\tCliente numero "+contClientes);
				contClientes++;

				//Forateamos el mesnaje recibido y lo mostramos por pantalla
				mensajeRecibido = desencriptar(new String(mensajeEntrante).trim());
				System.out.println("\t"+mensajeRecibido);

				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique su nombre: ");
				recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Nombre: ");

				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique su DNI: ");
				recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"DNI: ");

				calcularFiniquito(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido);

				System.out.println();
			}

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
		}finally{
			socket.close();
		}

	}

	public static void enviarMensaje(DatagramSocket socket, DatagramPacket paqueteRecibido, byte[] mensajeEntrante, String mensajeRecibido, String mensaje) {

		byte[] mensajeSaliente;
		String mensajeEnviado="";
		DatagramPacket paqueteEnviado;

		try {

			//Obtenemos Ip y puerto del paquete recibido
			int puertoCliente = paqueteRecibido.getPort();
			InetAddress direccionCliente = paqueteRecibido.getAddress();

			//enviamos un mensaje
			mensajeEnviado = encriptar(mensaje);

			//formateamos el mensaje saliente
			mensajeSaliente = mensajeEnviado.getBytes();

			//preparamos el paquete
			paqueteEnviado = new DatagramPacket(mensajeSaliente,mensajeEnviado.length(),direccionCliente,puertoCliente);
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

	public static String recibirMensaje(byte[] mensajeEntrante, DatagramPacket paqueteRecibido, DatagramSocket socket, String mensajeRecibido, String identificador) {

		try {

			mensajeEntrante = new byte[MAX_LEN];
			paqueteRecibido = new DatagramPacket(mensajeEntrante,mensajeEntrante.length);
			socket.receive(paqueteRecibido);
			mensajeRecibido = desencriptar(new String(mensajeEntrante).trim());
			System.out.println("\t"+identificador+mensajeRecibido);

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

	public static void calcularFiniquito(byte[] mensajeEntrante, DatagramPacket paqueteRecibido, DatagramSocket socket, String mensajeRecibido) {

		double salario = 0;
		int dias = 0;
		String mes = "";
		double salarioEq = 0;
		double pagas = 0;
		double pagasPro = 0;
		double vacaciones = 0;
		double antig = 0;
		double salarioDiario = 0;
		double indemnizacion = 0;
		double total = 0;

		enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique su salario base al mes: ");
		salario = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Salario base: : "));

		enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Ultimo mes trabajado:");
		mes = recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Ultimo mes: ");

		switch(mes) {
		//case "Enero","Marzo","Mayo","Julio","Agosto","Octubre","Diciembre":

			enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique los dias trabajados este mes:");
			dias = Integer.parseInt(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Dias trabajados en el ultimo mes: : "));

		if(dias<0 || dias>31) {
			System.out.println("Los dias introducidos son incorrectos.");
			break;
		}else {
			salarioEq = Math.round(((salario*dias)/31)*100.00)/100.00;
			pagas = (2*salario)/12;
			pagasPro = Math.round(((pagas*dias)/31)*100.00)/100.00;

			switch(mes) {
			case "Enero":
				vacaciones = Math.round(((dias*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				
				break;
				
			case "Marzo":
				vacaciones = Math.round((((31+28+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
				
			case "Mayo":
				vacaciones = Math.round((((31+28+31+30+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
				
			case "Julio":
				vacaciones = Math.round((((31+28+31+30+31+30+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
				
			case "Agosto":
				vacaciones = Math.round((((31+28+31+30+31+30+31+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
				
			case "Octubre":
				vacaciones = Math.round((((31+28+31+30+31+30+31+31+30+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
				
			case "Diciembre":
				vacaciones = Math.round((((31+28+31+30+31+30+31+31+30+31+30+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
				break;
			}

		}
		break;

		case "Febrero":
			enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique los dias trabajados este mes:");
			dias = Integer.parseInt(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Dias trabajados en el ultimo mes: : "));

			if(dias<0 || dias>28) {
				System.out.println("Los dias introducidos son incorrectos.");
				break;
			}else {
				salarioEq = Math.round(((salario*dias)/28)*100.00)/100.00;
				pagas = (2*salario)/12;
				pagasPro = Math.round(((pagas*dias)/31)*100.00)/100.00;
				
				vacaciones = Math.round((((31+dias)*30)/365)*100.00)/100.00;
				vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
				antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
				
				salarioDiario = (salario+pagas)*12/365;
				indemnizacion = 20*antig*salarioDiario;
				total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
				
				enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
			}
			break;

		//case "Abril","Junio","Septiembre","Noviembre":
			enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Indique los dias trabajados este mes:");
			dias = Integer.parseInt(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Dias trabajados en el ultimo mes: : "));

			if(dias<0 || dias>30) {
				System.out.println("Los dias introducidos son incorrectos.");
				break;
			}else {
				salarioEq = Math.round(((salario*dias)/30)*100.00)/100.00;
				pagas = (2*salario)/12;
				pagasPro = Math.round(((pagas*dias)/31)*100.00)/100.00;
				
				switch(mes) {
				case "Abril":
					vacaciones = Math.round((((31+28+31+dias)*30)/365)*100.00)/100.00;
					vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
					antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
					
					salarioDiario = (salario+pagas)*12/365;
					indemnizacion = 20*antig*salarioDiario;
					total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
					break;
					
				case "Junio":
					vacaciones = Math.round((((31+28+31+30+31+dias)*30)/365)*100.00)/100.00;
					vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
					antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
					
					salarioDiario = (salario+pagas)*12/365;
					indemnizacion = 20*antig*salarioDiario;
					total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
					
					break;
					
				case "Septiembre":
					vacaciones = Math.round((((31+28+31+30+31+30+31+31+dias)*30)/365)*100.00)/100.00;
					vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
					antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
					
					salarioDiario = (salario+pagas)*12/365;
					indemnizacion = 20*antig*salarioDiario;
					total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
					
					break;
					
				case "Noviembre":
					vacaciones = Math.round((((31+28+31+30+31+30+31+31+30+31+dias)*30)/365)*100.00)/100.00;
					vacaciones = Math.round((vacaciones*salario/30)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Cual es su antigüedad:");
					antig = Double.parseDouble(recibirMensaje(mensajeEntrante,paqueteRecibido,socket,mensajeRecibido,"Antigüedad: : "));
					
					salarioDiario = (salario+pagas)*12/365;
					indemnizacion = 20*antig*salarioDiario;
					total = Math.round((salarioEq + pagasPro + vacaciones + indemnizacion)*100.00)/100.00;
					
					enviarMensaje(socket,paqueteRecibido,mensajeEntrante,mensajeRecibido,"Su finiquito es de: "+total);
					break;
				}
			}
			break;
			//}

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
