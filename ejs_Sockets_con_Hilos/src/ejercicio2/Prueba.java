package ejercicio2;

import java.io.*;

public class Prueba {

	public static void main(String[] args) {
	 File f1 = new File("ejercicio2_archivos/prueba.obj");
	 try {
		DataOutputStream dos = new DataOutputStream (new FileOutputStream(f1));
		DataInputStream dis = new DataInputStream (new FileInputStream(f1));
		try {
			dos.writeUTF("esto es una prueba de archivo binario para ejercicio 2 de la hoja de sockets con hilos");
			dos.flush();
			
			while(dis.available()>0) {
				System.out.println( dis.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
