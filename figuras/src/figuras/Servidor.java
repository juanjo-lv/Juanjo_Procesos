package figuras;
import java.io.*;
import java.net.*;
public class Servidor {

	public static void main(String[] args) {
	try {
		ServerSocket servidor = new ServerSocket(5000);
		System.out.println("servidor iniciado");
		while(true) {
		Socket conexion = servidor.accept();
		System.out.println("cliente conectado");
		
		BufferedReader lectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		PrintWriter escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()),true);
		
		String mensaje = lectura.readLine();
		System.out.println(mensaje);
		int base,altura;
		double resultado;
		switch(mensaje) {
		case "1":
				 base = Integer.parseInt(lectura.readLine());
				 System.out.println(base);
				 altura = Integer.parseInt(lectura.readLine());
				 System.out.println(altura);
				
				 resultado = base * altura;
				 System.out.println(resultado);
				escribir.println(resultado);
			break;
		
		case "2":
			 base = Integer.parseInt(lectura.readLine());
			 altura = Integer.parseInt(lectura.readLine());
			
			 resultado = (base * altura)/2;
			escribir.println(resultado);
			break;
		}
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
