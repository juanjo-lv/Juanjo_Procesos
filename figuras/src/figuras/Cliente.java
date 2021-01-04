package figuras;
import java.io.*;
import java.net.*;
import java.util.*;
public class Cliente {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("127.0.0.1",5000);
			BufferedReader lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter escribir = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			String operacion,base,altura;
		while(true) {
			System.out.println("que operacion quieres mandar 1: cuadrado , 2 triangulo");
			operacion = sc.nextLine();
			escribir.println(operacion);
			System.out.println("operacion enviada");
			
			System.out.println("envia la base");
			base = sc.nextLine();
			escribir.println(base);
			
			System.out.println("envia la altura");
			altura = sc.nextLine();
			escribir.println(altura);
			
			System.out.println("el resultado es: "+lectura.readLine());
		}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
