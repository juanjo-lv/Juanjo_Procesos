package Ejercicio1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.*;
public class Cliente {

	public static void main(String[] args) {
	DatagramSocket mySocket = null;
	File f1 = new File("mensaje");
	BufferedReader bf = null;
	
	int port = 4000;
	try {
		mySocket = new DatagramSocket(port);
		
		byte[] buffer = new byte[1024];
		DatagramPacket datagram = new DatagramPacket(buffer, 1024);
		mySocket.receive(datagram);
		
		String mensaje = new String(buffer);
		
		Cifrado.desencriptarMensaje();
		String ms="";
		
		bf = new BufferedReader(new FileReader(f1));
		while( (ms = bf.readLine())!=null) {
			System.out.print(ms);
		}
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}
}
