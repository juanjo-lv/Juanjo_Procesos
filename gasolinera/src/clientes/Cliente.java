package clientes;
import java.net.*;
import java.io.*;

public class Cliente extends Thread{
	private final static String IP="127.0.0.1";
	private final static int PUERTO=5550;
	private static Socket conexion;
	private static BufferedReader lectura;
	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.start();
		
	}
	public void run() {
		try {
			
			conexion = new Socket(IP,PUERTO);
			System.out.println("hola cliente");
			lectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			
			String precio_gaso,precio_diesel,precio_gasoil;
			while(true) {
				
			System.out.println("El precio de la gasolina es: "+lectura.readLine());
			System.out.println("El precio del diesel es: "+lectura.readLine());
			System.out.println("El precio del gasoil es: "+lectura.readLine());
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
				lectura.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
