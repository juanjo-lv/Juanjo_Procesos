package ejercicio3;
import java.net.*;
import java.io.*;
import java.util.*;
public class Servidor {
final static int PUERTO = 6000;
	public static void main(String[] args) {
	
		String msg="+";
		String num1,num2;
		Double op=0.0;
		int[] nums = new int[2];
		
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
			
		/*
			switch(msg) {
			case "+":
				op=Integer.toString(num1+num2);
				System.out.println("operacion realizada");
				break;
			case "-":
				op=Integer.toString(num1-num2);
				System.out.println("operacion realizada");
				break;
			case "*":
				op=Integer.toString(num1*num2);
				System.out.println("operacion realizada");
				break;
			case "/":
				//se me ha olvidado considerar la division tengo que hacer la operacion en double para que 
				//salgan decimales y luego lo vuelvo a convertir, esto es un apaño para no tener que modificar el ejercicio 
				//entero
				double aux1,aux2;
				aux1 = num1;
				aux2 = num2;
				op=Double.toString(aux1/aux2);
				System.out.println("operacion realizada");
			}*/
			
			op = Double.parseDouble(num1)+Double.parseDouble(num2);
			
			escribir = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
			escribir.println(op);
			escribir.close();
			lectura.close();
			cliente.close();
		}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
