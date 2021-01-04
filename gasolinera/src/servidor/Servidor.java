package servidor;
import java.io.*;
import java.net.*;
import java.util.*;
public class Servidor {
	
	private final static int PUERTO=5550;
	private static ServerSocket servidor;
	private static Socket conexion;
	
	public static void main(String[] args) {
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Se ha iniciado el servidor");
			Scanner sc = new Scanner(System.in);
			int cont=1;
			String precio_gaso,precio_diesel,precio_gasoil;
			
			System.out.println("indica el precio de la gasolina");
			precio_gaso=sc.nextLine();
			while(true) {
				conexion = servidor.accept();
				System.out.println("se ha conectado un cliente");
				HiloServidor h = new HiloServidor(cont,conexion,precio_gaso);
				h.start();
				cont++;
				

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
