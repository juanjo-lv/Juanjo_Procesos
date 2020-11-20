package ejercicio3;

import java.net.*;
import java.io.*;
import java.util.*;

public class Telefono {

public static final int PUERTO =5000;

	public static void main(String[] args) {
		try {
			String mensaje1,mensaje2;
			BufferedReader lectura1,lectura2;
			PrintWriter escribir1,escribir2;
			
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Esperando conexion...");
		do {
		
			Socket cliente1 = servidor.accept();
			System.out.println("cliente aceptado");
			Socket cliente2 = servidor.accept();
			System.out.println("cliente aceptado");
			
			//Leer cadena del 1º cliente
			lectura1 = new BufferedReader(new InputStreamReader(cliente1.getInputStream()));
			mensaje1 = lectura1.readLine();
			System.out.println("mensaje del 1º cliente almacenado");
			
			//Enviamos la cadena a 2º cliente
			escribir1 = new PrintWriter(new OutputStreamWriter(cliente2.getOutputStream()),true);
			escribir1.write(mensaje1);
			System.out.println("Enviando al 2º cliente...");
			
			//Leer cadena del 2º cliente
			lectura2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
			mensaje2=lectura2.readLine();
			System.out.println("mensaje del 2º cliente almacenado");
			
			//Enviar cadena de 2º a 1º
			escribir2 = new PrintWriter(new OutputStreamWriter(cliente2.getOutputStream()),true);
			escribir2.write(mensaje2);
			System.out.println("Enviando al 1º cliente...");
			
			cliente1.close();
			cliente2.close();
		}while(mensaje1.equalsIgnoreCase("FIN"));
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
