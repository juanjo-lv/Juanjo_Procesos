package variosClientesUDP;
import java.net.InetAddress;

public class Cliente {
		  // La clase cliente contiene los elementos que nos van a permitir
		  // identificar a cada cliente del IRC.

		  private InetAddress dir; // Dir. de la maquina donde esta el cliente
		  private int puerto; // Puerto a traves del cual se comunica el cliente
		  private String Apodo; // identificativo del cliente

		  // Constructor de un cliente del IRC
		  Cliente (InetAddress dir, int puerto, String Apodo) {
		    this.puerto=puerto;
		    this.dir=dir;
		    this.Apodo=Apodo;
		  }

		  public int lee_puerto () {
		    return (this.puerto); 
		  }

		  public InetAddress lee_dir () {
		    return (this.dir);
		  }
		  
		  public String lee_Apodo() {
		    return (this.Apodo);
		  }
		
}
