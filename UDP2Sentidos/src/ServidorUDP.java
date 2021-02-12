import java.net.*;
/**
 * Programa que se comunica via protocolo UDP con un cliente
 * El cliente va mandando mensajes al servidor y este le responde: 
 * Si el mensaje empieza por "hola", responde "hola cliente".
 * Si el mensaje empieza por "adios", responde "adios cliente" y el cliente termina.
 * Si el mensaje no empieza por ninguna de las dos, responde "te ignoro".
 */
public class ServidorUDP {
 public static void main(String args[]) {
	final int MAX_LEN = 256;
	DatagramSocket socket = null;
	
	if (args.length != 1)
	      System.out.println ("Este programa necesita 1 parámetro");
	else {
		try {			 
			 byte[] mensaje_del_cliente; 
			 byte[] mensaje_al_cliente;
			
			 String mensaje_recibido;
			 String mensaje_mandado ="";
			 	
			 DatagramPacket envpaquete;
			 
			 int puerto;
			 InetAddress direccion;
				
			 //Creamos el socket (datagrama)
			 socket = new DatagramSocket(Integer.parseInt(args[0]));
			 
			 //Iniciamos el bucle
			 do {					 
				 mensaje_del_cliente = new byte[MAX_LEN]; // Limpiamos el buffer
				 
				 // Preparamos el paquete donde queremos recibir el mensaje del cliente
				 // Paquete donde encuentra el array en el que se guardará el mensaje que se recibe:
				 DatagramPacket paquete = new DatagramPacket(mensaje_del_cliente, mensaje_del_cliente.length);
				 
				 System.out.println("Preparado para recibir ");
				 // Recibimos el paquete
				 socket.receive(paquete);
				 
				 // Lo formateamos
				 mensaje_recibido = new String(mensaje_del_cliente).trim();
				 
				 // Lo mostramos por pantalla el mensaje recibido:
				 System.out.println(mensaje_recibido);
							 
				 //Obtenemos IP Y PUERTO del paquete recibido, se rellenó al hacer el receive
				 puerto = paquete.getPort();
				 direccion = paquete.getAddress();
				 System.out.println("Direccion del cliente " + direccion);
				 System.out.println("Puerto del cliente " + puerto);
				 
				 if (mensaje_recibido.startsWith("adios"))
					 mensaje_mandado="Adios cliente";		 		 
				 else if (mensaje_recibido.startsWith("hola"))
					 mensaje_mandado="Hola cliente";
				 else 
					 mensaje_mandado="Te ignoro";
				 
				 //formateamos el mensaje de salida
				 mensaje_al_cliente = mensaje_mandado.getBytes(); // Hay que convertirlo en array de bytes
			 
				 //Preparamos el paquete que queremos enviar
				 envpaquete = new DatagramPacket(mensaje_al_cliente, mensaje_mandado.length(), direccion, puerto);
				 // El puerto y la maquina es el que venía en el paquete del emisor
				 
				 // realizamos el envio
				 socket.send(envpaquete);
				
			} while (true);
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
