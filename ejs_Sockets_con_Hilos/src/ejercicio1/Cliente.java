package ejercicio1;

import java.util.*;
import java.net.*;
import java.io.*;

public class Cliente {
public static final String IP ="127.0.0.1";
public static final int PUERTO = 5000;

	public static void main(String[] args) {
		try {
			//Crear Streams
		    BufferedReader lectura;
		    PrintWriter escribir;
		    File f1 = new File("fichero.txt");
		    
		    /**
			 * conexion con servidor
			 */
		    
			Socket miSocket = new Socket (IP,PUERTO);
		
			/*
			 * Enviar fichero al servidor
			 */
			
		    escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			escribir.print(f1);
			
			miSocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
