package ejercicio2;
import java.net.*;
import java.io.*;

public class HiloServidor extends Thread{
	

	private Socket miSocket;
	private int numServ;
	private BufferedReader lectura;
	private PrintWriter escribir;
	
	
	public HiloServidor(Socket miSocket, int numServ) {
		this.miSocket=miSocket;
		this.numServ=numServ;
	}

	public void run() {
		try {
			File f = new File("ejercicio1_textos/archivo"+numServ+".txt");
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
			escribir = new PrintWriter(new FileWriter(f),true);
			
			String texto = lectura.readLine();
			
			escribir.println(texto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}