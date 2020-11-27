package clientes;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class Cliente {
	public static final String IP ="localhost";
	public static final int PUERTO_HORA = 6000;
	public static final int PUERTO_ECO = 6001;
	
	private int id ;
	private Socket socket;
	private static BufferedReader lectura;
	private static PrintWriter escribir;
	
	
	public static void main(String[] args) {
	int respuesta;
	do {
		respuesta=Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion \n"
				+ "1. Obtener la hora cada 2s \n"
				+ "2. Replicar un mensaje"));
	}while(respuesta!=1 && respuesta!=2);	
		
		switch(respuesta) {
		case 1: 
			conectarHora();
			break;
		case 2: 
			conectarEco();
		}
	}
	
	
	
	public static Socket conectar(String ip, int puerto) {
		Socket conexion=null;
		try {
			 conexion = new Socket (ip,puerto);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	//metodo para conectar al de la hora
	
	public static void conectarHora(){
		Socket con =null; 
		con= conectar(IP,PUERTO_HORA);
		try {
			lectura = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(lectura.readLine()!=null) {
				System.out.println(lectura.readLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				lectura.close();
				con.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//metodo para conectar al del eco
	
	public static void conectarEco() {
		Socket con = null;
		con = conectar(IP,PUERTO_ECO);
		String cad = JOptionPane.showInputDialog("escribe una frase para convertir a mayus");
		
		
		try {
			lectura = new BufferedReader(new InputStreamReader(con.getInputStream()));
			escribir = new PrintWriter ( new OutputStreamWriter(con.getOutputStream()),true);
			
			escribir.println(cad);
			System.out.println(lectura.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				escribir.close();
				lectura.close();
				con.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
