package Ejercicio1;
import java.net.*;

import javax.crypto.BadPaddingException;
public class Servidor {

	public static void main(String[] args) {
	String clave ="clave-simetrica1";	
	int puerto = 5000;
	DatagramSocket socket= null;
	DatagramPacket data = null;
	DatagramPacket dataenvio = null;
	byte[] buffer;
	byte[] buffenvio;
	
		
	
	try {
		socket = new DatagramSocket(puerto);
		System.out.println("Servidor UDP iniciado");
		while(true) {
		
		buffer = new byte[1024];
		data = new DatagramPacket(buffer,buffer.length);
		
		socket.receive(data);
		
		
		String mensaje_recibido = new String(buffer).trim();
		System.out.println("Mensaje del cliente recibido: "+mensaje_recibido);
		System.out.println("Encriptando...");
		System.out.println("Encriptacion completada");
		String mensaje_desencriptado = CifAES.decrypt(mensaje_recibido,clave);
		System.out.println("El mensaje es: "+mensaje_desencriptado);
		
		
		int num = Integer.parseInt(mensaje_desencriptado);
		String letra =Character.toString(calcularLetraArray(num));
		
		String dni = mensaje_desencriptado + letra;
		System.out.println("Calculando dni....");
		System.out.println("El dni que se enviará es: "+dni);
		String dni_encriptado = CifAES.encript(dni,clave);
		System.out.println("Resultado encriptado: "+dni_encriptado);
		buffenvio = dni_encriptado.getBytes();
		dataenvio = new DatagramPacket(buffenvio,buffenvio.length,data.getAddress(),data.getPort());
		
		socket.send(dataenvio);
		
		}
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e) {
		System.out.println("El intercambio de información ha fracasado vuelve a intentarlo");
	}
	
	}
   public static char calcularLetraArray(int dni){
        char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = dni%23;
        return caracteres[resto];
   }

}
