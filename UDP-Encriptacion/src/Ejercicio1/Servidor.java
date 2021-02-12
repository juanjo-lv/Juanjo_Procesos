package Ejercicio1;

import java.io.*;
import java.net.*;
public class Servidor {

	public static void main(String[] args) {
		DatagramSocket mySocket = null;
		BufferedReader bf;
		File f1 = new File("mensaje");
		
		String ip = "localhost";
		int puerto = 4000;
		String mensaje="Recuerda bajar al perro el lunes a las 9 ";
		String texto_encriptado="";
		
		
		try {
			texto_encriptado=CifAES.encript(mensaje);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		try {
			mySocket = new DatagramSocket();
			InetAddress receiverHost = InetAddress.getByName(ip);
			byte[] buffer = texto_encriptado.getBytes();
			DatagramPacket datagram = new DatagramPacket(buffer, buffer.length,receiverHost,puerto);	
			mySocket.send(datagram);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(Exception e) {
			
		}finally {
			System.out.println("Hemos terminado");
			mySocket.close();
		}
	
	
	
		
		
	}

}
