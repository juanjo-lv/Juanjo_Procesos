package variosClientesUDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Recibe_mensajes implements Runnable {
// Thread que se encarga de recibir los mensajes que envia el
// servidor, y presentarlos por la salida estandar.

  public DatagramSocket sock;

  // Constructor del Thread
  public Recibe_mensajes(DatagramSocket sock) {
    this.sock=sock;
  }

  public void run() {
      try {
        while (true)
        {
        	// Creamos un datagrama, y se bloquea el thread hasta que el servidor
        	// le envia un datagrama.
        	// Una vez el cliente lo ha recibido, lo muestra por pantalla.
	
	        DatagramPacket dp_entrada = new DatagramPacket (new byte [1024], 1024);
	        sock.receive(dp_entrada);
	        System.out.println(new String(dp_entrada.getData()));
	        System.out.println(dp_entrada.getData());
        }  //del while
      } // del try
      catch (IOException e) {
        System.err.println("Error en la entrada / salida");
      }
   }// del metodo RUN()
}

