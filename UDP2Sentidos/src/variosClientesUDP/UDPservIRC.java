package variosClientesUDP;
import java.net.*;
import java.io.*;

public class UDPservIRC {
  // Esta clase, contiene un vector de clientes que estan conectados al IRC
  // (4 como maximo). Cada elemento del vector, identifica de manera unica
  // a cada cliente.
 
  static Cliente vecClientes []=new Cliente[4];
  
  public static void main(String [] args) {
    int num=0; // Variable global que indica el n§ de conexiones que hay.
    boolean presente;
    DatagramSocket servidor=null;
    
    if (args.length==1) {
	    try {
	      //El socket UDP actuara de servidor en principio
	      servidor=new DatagramSocket(Integer.parseInt(args[0]));      
	      System.out.println("Esperando el primer paquete..."); 
	      while (true) {
	       //Creamos un paquete datagrama de recepcion
	        DatagramPacket dp_entrada = new DatagramPacket (new byte [1024],1024);
	
	        servidor.receive(dp_entrada); //Esperamos un mensaje
	
	        // Si leemos esta linea, es porque hemos recibido un Datagrama
	
	        if (num==0) {  // es el primer cliente del servidor
	          // Introducimos el primer cliente en el vector de clientes.
	        	//Creamos un objeto cliente con los datos que nos han llegado en el datagrama
	          vecClientes[num]=new Cliente(dp_entrada.getAddress(), dp_entrada.getPort(), new String(dp_entrada.getData()));
	          System.out.println("Se ha conectado el cliente "+new String(dp_entrada.getData()));
	          num++;
	        }
	        else if (num<4) {
	        // Si ya hay algunas conexiones, buscaremos
	        // dentro del vector, una direccion IP, y un puerto igual a la
	        // direccion IP y al puerto del datagrama que hemos recibido (datos del cliente que nos lo ha enviado).
	
	          presente=false;
	        
	          for (int i=0;i<num;i++)  
	            if (vecClientes[i].lee_dir().getHostName().equals(dp_entrada.getAddress().getHostName())) 
	              if (vecClientes[i].lee_puerto()==dp_entrada.getPort()) {
	                //Este cliente ya se encuentra en el vector
	                System.out.println("Recibido un paquete del usuario "+vecClientes[i].lee_Apodo());
	                presente=true;
	                break;
	              }
	          
	        if (presente==false) {
	        	 // El cliente es nuevo, y no esta en el vector.
	        	 // Lo introducimos en el vector
	        	 // El primer mensaje recibido será el apodo, el resto serán mensajes que queremos reenviar al resto de clientes
	             vecClientes[num]=new Cliente(dp_entrada.getAddress(),dp_entrada.getPort(),new String(dp_entrada.getData()));
	             num++; // aumentamos el n§ de conexiones al servidor
	             System.out.println("Se ha conectado el cliente "+new String(dp_entrada.getData())+". Numero de usuarios: "+num);
	        }
	        else {  // Tenemos que mandar a cada cliente, el mensaje que hemos recibido de otro cliente.
		        for (int i=0;i<num;i++)
		         {
		          System.out.println("Mandando nuevo paquete al usuario "+vecClientes[i].lee_Apodo()+": "+new String(dp_entrada.getData()));
		
		          //Creamos un paquete de salida y mandamos la nueva informacion
		          DatagramPacket dp_salida = new DatagramPacket (dp_entrada.getData(), dp_entrada.getLength(), vecClientes[i].lee_dir(), vecClientes[i].lee_puerto());
		          servidor.send(dp_salida);
		         } // del for
	       } // del else
	     }
	     }
	     }
	
	     catch (UnknownHostException e) {
	       System.err.println("Nombre de maquina servidora desconocida");
	     }
	     catch (ConnectException e) {
	       System.err.println("El servidor no esta conectado en " + args[0]); 
	     }  
	     catch (SocketException e) {
	       System.err.println("Error en una operacion del socket");
	     }
	     catch (IOException e) { 
	       System.err.println("Error en la lectura/escritura");
	     }
	     finally {
	    	servidor.close();
	     }
    }
    else System.out.println("Numero de parametros incorrectos"); 
  }
}
