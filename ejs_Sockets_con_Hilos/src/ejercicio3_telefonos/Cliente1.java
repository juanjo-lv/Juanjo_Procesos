package ejercicio3_telefonos;

import java.io.*;
import java.util.*;
import java.net.*;

public class Cliente1 {
	public static final String IP = "127.0.0.1";
	public static final int PUERTO = 5500;

	public static void main(String[] args) {

		String msg = " ";
		PrintWriter salida;
		BufferedReader entrada;
		Scanner sc = new Scanner(System.in);
		Socket miSocket;
		try {

			while (!msg.equalsIgnoreCase("FIN")) {
				miSocket = new Socket(IP, PUERTO);
				
				System.out.println("Escribe un mensaje para el cliente 2");
				msg = sc.nextLine();

				salida = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()), true);
				salida.write(msg);
				System.out.println("mensaje enviado con exito");
				
			/*	
				entrada = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
				msg=entrada.readLine();
				System.out.println(msg);
*/
				salida.close();
			//	entrada.close();
				miSocket.close();

			}
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