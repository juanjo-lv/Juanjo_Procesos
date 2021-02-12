package basico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
public class MainServidorB {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// El mismo puerto que se usa en la parte de enviar.
			MulticastSocket escucha = new MulticastSocket(55557);

			// Nos ponemos a la escucha de la misma IP de Multicast que se usó en la parte de enviar.
			escucha.joinGroup(InetAddress.getByName("230.0.0.1"));
								
			// Un array de bytes con tamaño suficiente para recoger el mensaje enviado, 
			// bastara con 4 bytes.
			byte [] dato = new byte [1024];

			// Se espera la recepción. La llamada a receive() se queda
			// bloqueada hasta que llegue un mensaje.
			DatagramPacket dgp = new DatagramPacket(dato, dato.length);
			escucha.receive(dgp);

			// Obtencion del dato ya relleno.
			dato = dgp.getData();
			escucha.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
