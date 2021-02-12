import java.net.*;

public class Emisor {
  public static void main(String[] args) {
	DatagramSocket  mySocket=null;
	
    if (args.length != 3)
      System.out.println ("Este programa necesita 3 parámetros");
    else {
      try {
        InetAddress receiverHost = InetAddress.getByName(args[0]);  //ip del receptor
        int receiverPort = Integer.parseInt(args[1]); 				//puerto por el que escucha el receptor
        String message = args[2]; 									//mensaje que se manda

        mySocket = new DatagramSocket();
        
        byte[ ] buffer = message.getBytes( );// Convertimos el string a un array de bytes, que es lo que se puede mandar
        DatagramPacket datagram = new DatagramPacket(buffer,  buffer.length, receiverHost, receiverPort);
        
        mySocket.send(datagram);
 
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
