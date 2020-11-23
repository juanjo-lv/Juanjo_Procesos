package ejercicio3;
import java.io.*;
import java.net.*;
import java.util.*;
public class Cliente1 {

public static final String IP="127.0.0.1";
public static final int PUERTO = 5000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String mensaje="";
			BufferedReader lectura;
			PrintWriter escribir;
			
			Socket miSocket = new Socket(IP,PUERTO);
			
			do {
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);	
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
		
			//Enviar primer mensaje al servidor
			System.out.println("Escribe un mensaje que quieras enviar, si pulsas FIN acaba la conversacion");
			mensaje = sc.nextLine();
			
			escribir.println(mensaje);
			
			
			//Recibir y visualizar el mensaje de 2
			
			mensaje = lectura.readLine();
			System.out.println(mensaje);
			
			lectura.close();
			escribir.close();
			}while(!mensaje.equalsIgnoreCase("fin"));
		
			miSocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
