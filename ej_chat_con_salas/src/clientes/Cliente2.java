package clientes;
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente2 {
	private static Socket conexion;
	private static BufferedReader lectura;
	private static PrintWriter escribir;
	
	public static void main(String[] args) {
		try{
			
			Scanner sc = new Scanner(System.in);
			
			String msg="";
			conexion = new Socket("localhost",4000);
			lectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()),true);
			
			
			
			
			while(!msg.equalsIgnoreCase(".")) {
				msg = lectura.readLine();
				if(!msg.equalsIgnoreCase(".")) {
					System.out.println("Cliente 1: "+msg);
					System.out.println("------------------");
					
					System.out.println("Escribe un mensaje que mandar");
					
					msg = sc.nextLine();
					escribir.println(msg);
				}else {
					System.out.println("adios cliente 1");
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
