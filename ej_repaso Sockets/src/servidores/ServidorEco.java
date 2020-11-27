package servidores;
import java.net.*;
import java.io.*;
public class ServidorEco {
	public static final int PUERTO = 6500;
	
	private static Socket socket;
	private static ServerSocket servidor;
	
	public static void main(String[] args) {
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor Eco iniciado");
			while(true) {
				socket = servidor.accept();
				HiloServEco h = new HiloServEco(socket);
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
