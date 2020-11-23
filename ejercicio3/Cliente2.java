package ejercicio3;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Cliente2 {
	
public static final String IP ="127.0.0.1";
public static final int PUERTO=5000;

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try {
		String mensaje;
		BufferedReader lectura;
		PrintWriter escribir;
		
		Socket miSocket = new Socket(IP,PUERTO);
		do {
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));	
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			
		//Recibir y visualizar el mensaje de 1
		mensaje = lectura.readLine();
		System.out.println(mensaje);
		
		//Enviar primer mensaje al servidor
		System.out.println("Escribe un mensaje que quieras enviar");
		mensaje = sc.nextLine();
		
		escribir.write(mensaje);
		System.out.println("mensaje enviado");
		
		

		}while(mensaje.equalsIgnoreCase("fin"));
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
