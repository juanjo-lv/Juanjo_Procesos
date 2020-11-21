package ejercicio3_telefonos;

import java.net.*;
import java.io.*;
import java.util.*;

public class Telefono {

	public static final int PUERTO = 5500;

	public static void main(String[] args) {

		String msg = " ", msg2 = " ";
		BufferedReader entrada1;
		PrintWriter salida1, salida2;
		ServerSocket servidor;
		Socket cliente, cliente2;
		try {
			System.out.println("Abriendo server...");
			servidor = new ServerSocket(PUERTO);

			
			while (!msg.equalsIgnoreCase("fin")) {
				cliente = servidor.accept();
				cliente2 = servidor.accept();
				// Recibe el mensaje de cliente 1
				entrada1 = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				msg = entrada1.readLine();
				System.out.println(msg);

				// Envía el mensaje a cliente 2

				salida2 = new PrintWriter(new OutputStreamWriter(cliente2.getOutputStream()), true);
				salida2.write(msg);
				
				entrada1.close();
				salida2.close();
				cliente.close();
				cliente2.close();
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
