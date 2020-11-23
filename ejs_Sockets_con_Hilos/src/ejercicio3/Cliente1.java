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
			String mensaje="",mensaje2="";
			BufferedReader lectura;
			PrintWriter escribir;
			
			Socket miSocket = new Socket(IP,PUERTO);
			
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);	
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));		
			do {
				
			//Enviar primer mensaje al servidor
			System.out.println("a Cliente 2:");
			mensaje = sc.nextLine();
			System.out.println("---------");
			
			escribir.println(mensaje);
			
			
			//Recibir y visualizar el mensaje de 2
			
			System.out.println("cliente 2: "+lectura.readLine());
			

			
			}while(!mensaje.equalsIgnoreCase("fin"));
			
			lectura.close();
			escribir.close();
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
