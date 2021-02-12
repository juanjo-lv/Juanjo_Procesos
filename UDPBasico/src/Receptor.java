import java.net.*;

public class Receptor {
  public static void main(String[] args) {
	final int MAX_LEN = 50;
	DatagramSocket  mySocket=null;

    if (args.length != 1)
      System.out.println("Este programa necesita 1 parámetro.");
    else {
      int port = Integer.parseInt(args[0]);
      
      try {
        mySocket = new DatagramSocket(port);

        byte[ ] buffer = new byte[MAX_LEN];
        
        DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
        
        mySocket.receive(datagram);
        
        String message = new String(buffer);
        System.out.println("Recibido del emisor: " + message);

      } // end try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
      finally {
    	  System.out.println("Terminamos y cerramos el socket");
    	  mySocket.close( );
      }
    } // end else
  } // end main
} // end class
