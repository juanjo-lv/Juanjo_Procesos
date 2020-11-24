package ejercicio2;

import java.io.*;

public class Prueba {

	public static void main(String[] args) {
		String cad="";
		try(DataInputStream dis = new DataInputStream(new FileInputStream("ejercicio2_archivos/archivo.dat"));){
			
		while(dis.available()>0){
			cad=dis.readUTF();
			 System.out.print(cad+" ");
		}
		System.out.println(cad);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
