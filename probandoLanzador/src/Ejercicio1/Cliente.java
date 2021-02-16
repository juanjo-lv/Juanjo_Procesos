package Ejercicio1;

import java.net.*;
import java.security.InvalidKeyException;

import javax.swing.JOptionPane;
public class Cliente{

	public static void main(String[] args) {
		String ip = "localhost";
		int puerto = 5000;
				
		DatagramPacket data=null;
		DatagramPacket datavuelta = null;
		DatagramSocket mySocket=null;
		
		try {
			String clave = JOptionPane.showInputDialog("Introduce la clave AES");
			InetAddress host = InetAddress.getByName(ip);
		    mySocket = new DatagramSocket();
	
			String mensaje = introducirDni();
			String mensaje_encriptado = CifAES.encript(mensaje,clave);
			System.out.println("Encriptaci�n completada tu mensaje es: "+mensaje_encriptado);
			
			byte[] buffer = mensaje_encriptado.getBytes();
			byte[] buffrecogida = new byte[1024];
			
			data = new DatagramPacket(buffer,buffer.length,host,puerto);
			datavuelta = new DatagramPacket(buffrecogida,buffrecogida.length);
			
			mySocket.send(data);
			System.out.println("Mensaje enviado");
			
			mySocket.receive(datavuelta);
			
			String dni_encriptado = new String(buffrecogida).trim();
			System.out.println("Recibiendo Dni completo encriptado..."+dni_encriptado);
			
			String dni_recuperado = CifAES.decrypt(dni_encriptado,clave);
			System.out.println(
					"Un momento por favor...");
			System.out.println(
					"su dni es :"+dni_recuperado);
					
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static String introducirDni() {
		int dni;
		String cad;
		boolean entero = false;
		
		do {
			cad="";
		    try{
		    	dni = Integer.parseInt(JOptionPane.showInputDialog("introduce tu dni sin letra"));
		    	cad = cad+dni;
		        entero = true;
		    }catch(NumberFormatException e){
		        entero = false;
		    }
			
		 }while(cad.length()<8 && cad.length()>8);
		
		return cad;
	}

}
