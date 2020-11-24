package ejercicio2;
import java.net.*;
import java.io.*;

public class HiloServidor extends Thread{
	

	private Socket miSocket;
	private int numServ;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	
	public HiloServidor(Socket miSocket, int numServ) {
		this.miSocket=miSocket;
		this.numServ=numServ;
	}

	public void run() {
		try {
			File f = new File("ejercicio2_archivos/prueba"+numServ+".obj");
			dis = new DataInputStream((miSocket.getInputStream()));
			dos = new DataOutputStream(new FileOutputStream(f));
			
			String texto = dis.readUTF();
			
			dos.writeUTF(texto);
			dos.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}