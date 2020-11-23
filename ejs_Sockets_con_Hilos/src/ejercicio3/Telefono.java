package ejercicio3;

import java.net.*;
import java.io.*;
import java.util.*;

public class Telefono {

public static final int PUERTO =5000;

	public static void main(String[] args) {
		try {
			String mensaje1="",mensaje2="";
			BufferedReader lectura1,lectura2;
			PrintWriter escribir1,escribir2;
			
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Esperando conexion...");
			
			//CLIENTES
			Socket cliente1 = servidor.accept();
			System.out.println("cliente aceptado");
			Socket cliente2 = servidor.accept();
			System.out.println("cliente aceptado");
			
			//BUFFERS
			lectura1 = new BufferedReader(new InputStreamReader(cliente1.getInputStream()));
			escribir1 = new PrintWriter(new OutputStreamWriter(cliente2.getOutputStream()),true);
			
			lectura2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
			escribir2 = new PrintWriter(new OutputStreamWriter(cliente1.getOutputStream()),true);
			
			
		do {
			//recibir de 1
			
			mensaje1 = lectura1.readLine();
			
			
		if(!mensaje1.equalsIgnoreCase("fin")) {
			//Enviamos la cadena a 2º cliente
			
			escribir1.println(mensaje1);
	
			//Leer cadena del 2º cliente
			mensaje2=lectura2.readLine();
		
			
			//enviar mensaje de 2 a 1
			escribir2.println(mensaje2);
			
		}else {
			
			escribir1.println(mensaje1);
		}
			

			
		}while(!mensaje1.equalsIgnoreCase("FIN"));
		
			System.out.println("se cierra el server");
			cliente1.close();
			cliente2.close();
			servidor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
