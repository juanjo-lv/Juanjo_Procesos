package ejercicio2;
import java.net.*;
import java.io.*;
public class Servidor {
final static int PUERTO =6000;
	public static void main(String[] args) {
		int cont = 2;
		Double num;
		boolean comprobar=true;
		try {
			
			
			
			while(comprobar){
				System.out.println("Esperando a conectarse");
				ServerSocket servidor = new ServerSocket(PUERTO);
				Socket cliente = servidor.accept();	
				BufferedReader lectura ;
				PrintWriter escribir;
				
				lectura = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				num = Double.parseDouble(lectura.readLine());
				num = Math.pow(num, 2);
				System.out.println("el cuadrado de la posicion "+(cont-1)+" es "+num);
				
				escribir = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);
				escribir.println(num);
				
				servidor.close();
				lectura.close();
				escribir.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
