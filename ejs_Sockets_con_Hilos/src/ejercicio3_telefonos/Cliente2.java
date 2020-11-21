package ejercicio3_telefonos;
import java.io.*;
import java.util.*;
import java.net.*;
public class Cliente2 {
	public static final String IP = "127.0.0.1";
	public static final int PUERTO=5000;
	
	public static void main(String[] args) {
		
		String msg=" ";
		
		PrintWriter salida;
		BufferedReader entrada;
		
		Scanner sc = new Scanner(System.in);
		
	try {
		
		Socket miSocket = new Socket(IP,PUERTO);
		
		System.out.println("Escribe un mensaje para el cliente 1");
		msg= sc.nextLine();
		
		salida = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
		salida.write(msg);
		
		//Ahora visualiza el mensaje de 1
		
		entrada = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
		System.out.println(entrada.readLine());
		
		
		
		
		
		
		
		
	}catch (UnknownHostException unknownHostExcept) {
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
