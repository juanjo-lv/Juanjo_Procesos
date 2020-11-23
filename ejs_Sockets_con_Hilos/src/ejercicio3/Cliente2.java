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
		String mensaje,mensaje2;
		BufferedReader lectura;
		PrintWriter escribir;
		
		Socket miSocket = new Socket(IP,PUERTO);
		do {
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));	
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			
		//Recibir y visualizar el mensaje de 1
		mensaje = lectura.readLine();
		System.out.println("cliente 1: "+mensaje);
		
		if(!mensaje.equalsIgnoreCase("fin")) {
		
		//Enviar primer mensaje al servidor
		System.out.println("a cliente 1:");
		mensaje2 = sc.nextLine();
		System.out.println("---------");
		escribir.println(mensaje2);
		
		}else {
			System.out.println("el chat se ha terminado");
		}
	
		}while(!mensaje.equalsIgnoreCase("fin"));
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
