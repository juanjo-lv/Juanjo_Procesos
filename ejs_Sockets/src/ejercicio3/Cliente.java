package ejercicio3;
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {
	final static String IP="localhost";
	final static int PUERTO = 6000;
	public static String dameOperador(Scanner sc) {
		String msg="";
		do {
			System.out.println("introduce un operador");
			msg = sc.nextLine();
		
			if(!msg.equalsIgnoreCase("$") && !msg.equalsIgnoreCase("+") && !msg.equalsIgnoreCase("-") && !msg.equalsIgnoreCase("*") 
			&& !msg.equalsIgnoreCase("/")) {
				System.out.println("Operador no valido introduce uno de nuevo");
			}else {
				System.out.println("has elegido el operador: "+msg);
			}
			
			
		}while(!msg.equalsIgnoreCase("$") && !msg.equalsIgnoreCase("+") && !msg.equalsIgnoreCase("-") && !msg.equalsIgnoreCase("*") 
			&& !msg.equalsIgnoreCase("/"));
		return msg;
	}
	public static int dameNum(Scanner sc) {
		int num;
		System.out.println("Introduce un numero");
		num = sc.nextInt();
		return num;
	}
	public static void main(String[] args) {
		String msg="";
		int num1,num2;
		String op="";
		Scanner sc = new Scanner(System.in);
	try {	
		Socket miSocket =new Socket(IP,PUERTO);
		BufferedReader lectura;
		PrintWriter escribir,escribir2,escribir3;
		
		
		msg = dameOperador(sc);
		
		while(!msg.equalsIgnoreCase("$")) {
			num1 = dameNum(sc);
		    num2 = dameNum(sc);
		
			
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			escribir.println(msg);
			
			
			escribir.println(num1);
			
			
			escribir.println(num2);
			
			lectura = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
			op = lectura.readLine();
			System.out.println("El resultado de la operación es: "+op);
			
			lectura.close();
			escribir.close();

			miSocket.close();
			
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
