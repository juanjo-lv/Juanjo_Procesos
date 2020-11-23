package ejercicio3_telefonos;

import java.io.*;
import java.util.*;
import java.net.*;

public class Cliente2 {
	public static final String IP = "127.0.0.1";
	public static final int PUERTO = 5500;

	public static void main(String[] args) {

		String msg = " ";
		PrintWriter salida;
		BufferedReader entrada;
		Scanner sc = new Scanner(System.in);
		Socket miSocket;
		try {
			miSocket = new Socket(IP, PUERTO);
			salida = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			entrada = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
		
			msg=entrada.readLine();
			System.out.println(msg);
			
			while(!msg.equalsIgnoreCase("fin")){
			
			//lee
			msg=entrada.readLine();
			System.out.println(msg);
			
			
			System.out.println("Envia un mensaje a 1");
			msg=sc.nextLine();
				
			salida.write(msg);
			System.out.println("mensaje enviado");
			
			}

			salida.close();
			entrada.close();
			miSocket.close();
			
		} catch (UnknownHostException unknownHostExcept) {
			System.err.println("->x Error en la operacion de socket!");
		} catch (SocketException socketExcept) {
			System.err.println("->x Error el servidor no esta conectado!");
		} catch (IOException ioExcept) {
			System.err.println("->x Error en la lectura/escritura I/O");
		} catch (Exception exception) {
			System.err.println("->x Error en la operacion!");
		}
	}

}
