package ejercicio3_telefonos;

import java.net.*;
import java.io.*;
import java.util.*;

public class Telefono {

	public static final int PUERTO = 5500;

	public static void main(String[] args) {

		String msg = "", msg2 = "";
		BufferedReader entrada1;
		PrintWriter salida1;
		ServerSocket servidor;
		Socket cliente;
		try {
			System.out.println("Abriendo server...");
			servidor = new ServerSocket(PUERTO);

			cliente = servidor.accept();
			System.out.println("cliente aceptado");

			// Recibe el mensaje de cliente 1
			entrada1 = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			System.out.println(entrada1.readLine());

		} catch (UnknownHostException unknownHostExcept) {
			System.err.println("->x Error en la operacion de socket!");
		} catch (SocketException socketExcept) {
			System.out.println(socketExcept);
			System.err.println("->x Error el servidor no esta conectado!");
		} catch (IOException ioExcept) {
			System.err.println("->x Error en la lectura/escritura I/O");
		} catch (Exception exception) {
			System.err.println("->x Error en la operacion!");
		}
	}
}
