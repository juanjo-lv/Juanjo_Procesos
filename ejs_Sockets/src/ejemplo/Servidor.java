package ejemplo;
import java.io.*;
import java.net.*;
public class Servidor {
	final static int NUMCLI = 3;
	final static int PUERTO = 6000;
	
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			PrintWriter salida;
			
			for(int i=0;i<NUMCLI;i++) {
				System.out.println("Esperando la conexion de un cliente...");
				Socket cliente = servidor.accept();
			
				System.out.println("Recidbida la conexion del cliente "+i);
			
			//Creamos el buffer para enviar al cliente informacion a traves del socket
		    //salida = new PrintWriter(cliente.getOutputStream());
			salida = new PrintWriter(cliente.getOutputStream(),true);
			String msg= "Hola cliente "+i;
			
			salida.println(msg); //imprime el mensaje
			//salida.flush() necesario si no ponemus true en la instanciacion de salida
			cliente.close(); //cerrar socket asignado al cliente			
			}
			servidor.close(); //cerrar socket
		}catch(SocketException e) {
			System.err.println("Error en una operacion de socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida"); 
		}catch(Exception e) {
			System.err.println("Error en la operacion");
		}

	}

}
