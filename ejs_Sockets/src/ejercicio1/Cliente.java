package ejercicio1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente {
	final static String IP="localhost";
	final static int PUERTO = 6000;
	public static void main(String[] args) {
		String msg ="";
		Scanner sc = new Scanner(System.in);
		
	
		
		try {
			
			while(!msg.equalsIgnoreCase(".")) {
				System.out.println("Escribe un mensaje");
				msg= sc.nextLine();
				if(msg.equalsIgnoreCase(".")) {
					break;
				}
			
			Socket misocket = new Socket(IP,PUERTO);
			BufferedReader lectura ;
			PrintWriter salida ;
			
			System.out.println("enviando tu mensaje");
			salida = new PrintWriter(new OutputStreamWriter(misocket.getOutputStream()),true);
			salida.println(msg);
			
			System.out.println("recogiendo mensaje");
			lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			System.out.println(lectura.readLine());
			}	
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
