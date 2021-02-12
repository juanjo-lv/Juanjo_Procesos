package variosClientesUDP;
import java.net.*;
import java.io.*;


public class UDPcliIRC {
  public static void main(String [] args) {
    
    
    if (args.length==2) {
    	int puerto=Integer.parseInt(args[1]); // Puerto donde se ejecuta el servidor
	    try {
	      DatagramSocket misocket=new DatagramSocket();
	      InetAddress addr=InetAddress.getByName(args[0]);//Se recibe el nombre/IP del servidor por parámetro
	
	      BufferedReader datos=new BufferedReader(new InputStreamReader (System.in));
	
	      //Con cada cliente, creamos el Thread para recibir mensajes del servidor y lo lanzamos
	      //Se quedará esperando por mensajes del servidor
	      new Thread(new Recibe_mensajes(misocket)).start();
	
	      System.out.print("Introduce tu Apodo: "); // Identificacion del usuario
	      String Apodo=new String(datos.readLine());
	      System.out.println("Introduce tus mensajes:");
	
	      //Creamos un paquete datagrama de salida para mandar los datos
	      DatagramPacket dp_salida = new DatagramPacket (Apodo.getBytes(),Apodo.getBytes().length, addr, puerto);
	      misocket.send(dp_salida);//De momento, manda el apodo al servidor
	      
	      while (true) { // Bucle infinito de envio de datos al servidor
	        String linea = datos.readLine();
	        String mensaje = Apodo+":: "+linea;
	        dp_salida = new DatagramPacket (mensaje.getBytes(), mensaje.getBytes().length, addr, puerto);
	        misocket.send(dp_salida);//Manda las líneas que se van introduciendo por teclado
	      }
	     }
	
	     catch (UnknownHostException e) {
	       System.err.println("Nombre de maquina servidora desconocida");
	     }
	     catch (ConnectException e) {
	       System.err.println("El servidor no esta conectado en " + args[0]); 
	     }  
	     catch (SocketException e) {
	       System.err.println("Error en una operacion del socket");
	     }
	     catch (IOException e) { 
	       System.err.println("Error en la lectura/escritura");
	     }
    }
    else System.out.println("Numero de parametros incorrectos"); 
  }
}



