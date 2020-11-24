package ejercicio1;

import java.net.*;
import java.io.*;


public class Servidor {
public static final int PUERTO=5500;

	public static void main(String[] args) {
	ServerSocket servidor;
	System.out.println("Iniciando server...");
	
	try {
		servidor = new ServerSocket(PUERTO);
		int cont=1;
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Cliente nº"+cont+" conectando...");
			HiloServidor h = new HiloServidor(socket,cont);
			h.start();
			cont++;
			
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
