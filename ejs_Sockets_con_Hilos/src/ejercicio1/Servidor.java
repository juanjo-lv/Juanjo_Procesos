package ejercicio1;
import java.io.*;
import java.util.*;
import java.net.*;

public class Servidor {
public static final int PUERTO = 5000;
	public static void main(String[] args) {
		try {
			FileReader fr;
			BufferedReader lectura;
			
			ServerSocket servidor = new ServerSocket(PUERTO);
			Socket cliente = servidor.accept();
			
			lectura = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
		
			String cadena;
		      FileReader f = new FileReader(lectura.readLine());
		      BufferedReader b = new BufferedReader(f);
		      while((cadena = b.readLine())!=null) {
		          System.out.println(cadena);
		      }
		      b.close();
			
			cliente.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
