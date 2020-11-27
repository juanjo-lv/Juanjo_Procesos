package servidores;

import java.io.*;
import java.net.*;


public class HiloServEco extends Thread{

	private Socket socket;
	private BufferedReader lectura;
	private PrintWriter escribir;
	
	public HiloServEco(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		String cad;
		
		try {
			escribir = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			cad = lectura.readLine().toUpperCase();
			escribir.println(cad);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				lectura.close();
				escribir.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
