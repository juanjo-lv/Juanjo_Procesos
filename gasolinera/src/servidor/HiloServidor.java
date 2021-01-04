package servidor;
import java.net.*;
import java.io.*;
import java.util.*;
public class HiloServidor extends Thread{
	
	private static Socket conexion;
	private static int n_conexion;
	private static PrintWriter escribir;
	private static String precio1;
	
	public HiloServidor(int n_conexion,Socket conexion,String precio1) {
		this.n_conexion = n_conexion;
		this.conexion=conexion;
		this.precio1=precio1;
		
	}
	
	
	public void run() {
		try {
			escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()),true);
			Scanner sc = new Scanner(System.in);

				escribir.println(precio1);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
				escribir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
