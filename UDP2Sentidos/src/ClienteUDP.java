import java.net.*;
import java.io.*;
/**
 * Programa que se comunica via protocolo UDP con un servidor
 * recibe como parámetros la ip del servidor y el puerto por donde el servidor
 * atiende las peticiones
 */

public class ClienteUDP {
 public static void main(String args[]) {
	final int MAX_LEN = 256;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	//Definimos el sockets, número de bytes del buffer, y mensaje.
	DatagramSocket socket=null;
	InetAddress address;
	byte[] mensaje_bytes;
	 
	 String mensaje="";
	 //mensaje_bytes=mensaje.getBytes();
	 
	//Paquete
	 DatagramPacket paquete;
	 
	 String cadenaMensaje="";
	 
	 DatagramPacket servPaquete;
	 
	 byte[] mensaje_recibido = new byte[MAX_LEN];
	 if (args.length != 2)
	      System.out.println ("Este programa necesita 2 parámetros");
	 		// inicia la conversacion, asi que necesita saber la maquina y el puerto al que mandamos los paquetes
	 else {
		 try {
	
			 socket = new DatagramSocket();
			 
			 address=InetAddress.getByName(args[0]);
			 System.out.println("direccion " + address);
			 
			 do {
				 
				 System.out.println("Introduce mensaje para el receptor ");
				 mensaje = in.readLine(); // leemos una línea del usuario
				 mensaje_bytes = mensaje.getBytes(); // La transformamos en array de bytes
			
				 System.out.println("length " + mensaje_bytes.length);
				 
				 paquete = new DatagramPacket(mensaje_bytes, mensaje.length(), address, Integer.parseInt(args[1]));				 
				 
				 socket.send(paquete);
				 
				 // Crea el espacio para recibir paquetes del servidor
				 mensaje_recibido = new byte[MAX_LEN];
				 
				//Esperamos a recibir un paquete
				 servPaquete = new DatagramPacket(mensaje_recibido, mensaje_recibido.length);
				 socket.receive(servPaquete);
				 
				//Convertimos el mensaje recibido en un string
				 cadenaMensaje = new String(mensaje_recibido).trim();
				 
				//Imprimimos el paquete recibido
				 System.out.println("recibido " + cadenaMensaje);
			 } while (!mensaje.startsWith("adios"));
		 }
		 catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		 }
		 finally {
			 socket.close();
		 }
	 }
}
}