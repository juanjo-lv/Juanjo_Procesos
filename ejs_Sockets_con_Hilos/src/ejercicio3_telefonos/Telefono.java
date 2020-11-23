package ejercicio3_telefonos;

import java.net.*;
import java.io.*;
import java.util.*;

public class Telefono {

	public static final int PUERTO = 5500;

	public static void main(String[] args) {

		String msg = "", msg2 = "";
		BufferedReader entrada1, entrada2;
		PrintWriter salida1, salida2;
		ServerSocket servidor;
		Socket cliente, cliente2;
		try {
			System.out.println("Abriendo server...");

			servidor = new ServerSocket(PUERTO);

			System.out.println("------------------------------");
			System.out.println("SERVIDOR DEL CHAT");
			System.out.println("------------------------------");

			// clientes
			cliente = servidor.accept();
			System.out.println("cliente 1 aceptado");
			cliente2 = servidor.accept();
			System.out.println("cliente 2 aceptado");

			// buffers
			entrada1 = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida1 = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);
			entrada2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
			salida2 = new PrintWriter(new OutputStreamWriter(cliente2.getOutputStream()), true);

			do {

				// Recibe el mensaje de cliente 1 y se la envia a cliente2

				
					msg= entrada1.readLine();
					System.out.println(msg);
					salida2.write(msg);

				// Recibe de cliente 2 y envia a 1

				msg2 = entrada2.readLine();
				salida1.write(msg2);
				

			} while (!msg.equalsIgnoreCase("fin"));

			entrada1.close();
			entrada2.close();
			salida1.close();
			salida2.close();
			cliente.close();
			cliente2.close();

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
