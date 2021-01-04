package servidor;
import java.io.IOException;
import java.net.*;

public class Servidor{
	private static ServerSocket servidor;
	private static Socket conexion;
	private static Socket conexion2;
	
	public static void main(String[] args) {
	try {
		int cont=0;
		 servidor = new ServerSocket(4000);
		 System.out.println("Servidor de chat iniciado");
		 while(true) {
			 
			 cont++;
			 conexion = servidor.accept();
			 System.out.println("Entra cliente 1");
			 
			 
			 conexion2 = servidor.accept();
			 System.out.println("Entra cliente 2");
			 
			 HiloServidor h = new HiloServidor(conexion,conexion2,cont);
			 h.start();
			 
		 }
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conexion.close();		
			conexion2.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	}

}
