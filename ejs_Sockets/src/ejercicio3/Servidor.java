package ejercicio3;
import java.net.*;
import java.io.*;
import java.util.*;
public class Servidor {
final static int PUERTO = 6000;
	public static void main(String[] args) {
	
		String msg=" ";
		String num1,num2;
		Double op=0.0;
	
		
		try {
			while(true) {
			System.out.println("Esperando conexion");	
			
			ServerSocket servidor = new ServerSocket(PUERTO);
			Socket cliente = servidor.accept();
			System.out.println("cliente aceptado");
			
			BufferedReader lectura;
			PrintWriter escribir;
			
			//recibe la operacion
			
			lectura = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			msg = lectura.readLine();
			System.out.println(msg);
			System.out.println("operacion recibida");
		
			
			num1=lectura.readLine();
			System.out.println("numero recibido");
			
			
			num2 = lectura.readLine();
			System.out.println("numero recibido");
			
		
			switch(msg) {
			case "+":
				op=Double.parseDouble(num1)+Double.parseDouble(num2);
				System.out.println("operacion realizada");
				break;
			case "-":
				op=Double.parseDouble(num1)-Double.parseDouble(num2);
				System.out.println("operacion realizada");
				break;
			case "*":
				op=Double.parseDouble(num1)*Double.parseDouble(num2);
				System.out.println("operacion realizada");
				break;
			case "/":
				op=Double.parseDouble(num1)/Double.parseDouble(num2);
				System.out.println("operacion realizada");
				
			}
			
			
			escribir = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
			escribir.println(op);
			
			escribir.close();
			lectura.close();
			cliente.close();
			servidor.close();
			
			
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
