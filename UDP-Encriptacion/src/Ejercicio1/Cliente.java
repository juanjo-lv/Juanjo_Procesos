package Ejercicio1;

import java.net.*;

import javax.swing.JOptionPane;
public class Cliente {

	public static void main(String[] args) {
		String ip = "localhost";
		int puerto = 5000;
				;
		DatagramPacket data=null;
		DatagramPacket datavuelta = null;
		DatagramSocket mySocket=null;
		
		try {
			InetAddress host = InetAddress.getByName(ip);
		    mySocket = new DatagramSocket();
	
			String mensaje = JOptionPane.showInputDialog("Introduce tu DNI sin letra");
			String mensaje_encriptado = CifAES.encript(mensaje);
			JOptionPane.showMessageDialog(null,"Encriptación completada tu mensaje es: "+mensaje_encriptado);
			
			byte[] buffer = mensaje_encriptado.getBytes();
			byte[] buffrecogida = new byte[1024];
			
			data = new DatagramPacket(buffer,buffer.length,host,puerto);
			datavuelta = new DatagramPacket(buffrecogida,buffrecogida.length);
			
			mySocket.send(data);
			JOptionPane.showMessageDialog(null,"Mensaje enviado");
			
			mySocket.receive(datavuelta);
			
			String dni_encriptado = new String(buffrecogida).trim();
			JOptionPane.showMessageDialog(null,"Recibiendo Dni completo encriptado..."+dni_encriptado);
			
			String dni_recuperado = CifAES.decrypt(dni_encriptado);
			JOptionPane.showMessageDialog(null,
					"Un momento por favor...");
			JOptionPane.showMessageDialog(null,
					"su dni es :"+dni_recuperado);
					
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
