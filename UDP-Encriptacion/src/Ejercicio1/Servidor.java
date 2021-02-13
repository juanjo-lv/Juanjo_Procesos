package Ejercicio1;
import java.net.*;
public class Servidor {

	public static void main(String[] args) {
	int puerto = 5000;
	DatagramSocket socket= null;
	DatagramPacket data = null;
	DatagramPacket dataenvio = null;
	byte[] buffer;
	byte[] buffenvio;
	try {
		socket = new DatagramSocket(puerto);
		buffer = new byte[1024];
		data = new DatagramPacket(buffer,buffer.length);
		
		socket.receive(data);
		
		
		String mensaje_recibido = new String(buffer).trim();
		String mensaje_desencriptado = CifAES.decrypt(mensaje_recibido);
		
		int num = Integer.parseInt(mensaje_desencriptado);
		String letra =Character.toString(calcularLetraArray(num));
		
		String dni = mensaje_desencriptado + letra;
		String dni_encriptado = CifAES.encript(dni);
		buffenvio = dni_encriptado.getBytes();
		dataenvio = new DatagramPacket(buffenvio,buffenvio.length,data.getAddress(),data.getPort());
		
		socket.send(dataenvio);
		
		
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
   public static char calcularLetraArray(int dni){
        char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = dni%23;
        return caracteres[resto];
   }

}
