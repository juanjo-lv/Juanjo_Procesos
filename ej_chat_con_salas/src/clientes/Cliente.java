package clientes;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Cliente {
	private static Socket conexion;
	private static BufferedReader lectura;
	private static PrintWriter escribir;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String msg="";
			conexion = new Socket("localhost",4000);
			lectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()),true);
			
			
			
			while(!msg.equalsIgnoreCase(".")){
				
			System.out.println("Escribe un mensaje que mandar");
			msg = sc.nextLine();
			escribir.println(msg);
			
			if(!msg.equalsIgnoreCase(".")) {
				System.out.println("Cliente 2: "+lectura.readLine());
				System.out.println("--------------------------------");
			}
			
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				System.out.println("Has abandonado la sala");
				lectura.close();
				escribir.close();
				conexion.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
