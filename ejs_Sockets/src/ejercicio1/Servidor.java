package ejercicio1;

import java.net.*;
import java.io.*;

public class Servidor {
	final static int PUERTO = 6000;
	public static void main(String[] args) {
	try {
		String msg ="";
		
		ServerSocket servidor = new ServerSocket(PUERTO);
		PrintWriter salida;
		BufferedReader lectura;
		
		
		System.out.println("Esperando la conexion de un cliente...");
	while(true){
		Socket cliente = servidor.accept();
		
		System.out.println("conectado cliente");
		
		System.out.println("leyendo la frase");
		lectura = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		msg = lectura.readLine().toUpperCase();
		
		System.out.println("Convirtiendo y enviando frase a mayusculas");
		salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);
		salida.println(msg);
		
		cliente.close();
		lectura.close();
		salida.close();
	}

		
		
		
		
		
	}catch(SocketException e) {
		System.err.println("Error en una operacion de socket");
	}catch(IOException e) {
		System.err.println("Error en una operacion de entrada/salida"); 
	}catch(Exception e) {
		System.err.println("Error en la operacion");
	}
	}

}
