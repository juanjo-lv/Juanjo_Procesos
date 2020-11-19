package ejercicio2;
import java.net.*;
import java.io.*;
public class Cliente {
final static String IP ="localhost";
final static int PUERTO = 6000;


	public static void main(String[] args) {
		boolean comprobar = true;
		try {
			
			
		for(int i=2; i<args.length;i++) {
			Socket misocket= new Socket(args[0],Integer.parseInt(args[1]));
			BufferedReader lectura;
			PrintWriter escribir;
			
			
			escribir = new PrintWriter(new OutputStreamWriter(misocket.getOutputStream()),true);
			escribir.println(args[i]);
			
			lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			System.out.println("el cuadrado del elemento "+i+" es "+lectura.readLine());
			
			
			misocket.close();
			lectura.close();
			escribir.close();
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
