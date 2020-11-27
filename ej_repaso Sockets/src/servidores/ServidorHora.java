package servidores;
import java.io.*;
import java.net.*;
public class ServidorHora {
	
	public static final int PUERTO = 7000;
	
	private static Socket conexion;
	private static ServerSocket servidor;
	
	public static void main(String[] args) {
	
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor Hora iniciado");
			while(true) {
				conexion = servidor.accept();
				HiloServHora h = new HiloServHora(conexion);
				h.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
