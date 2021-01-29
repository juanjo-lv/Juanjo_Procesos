package codigoFTP;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;





public class Servidor {
	public static final String DIRECCION ="/";
	
	
	public static ArrayList<String> cambiarListarDirectorio(String nombre, FTPClient cliente) {
		ArrayList<String> listado = new ArrayList<String>();
		try {
			
			String cad ="";
			cliente.changeWorkingDirectory(nombre);
			FTPFile[] ficheros = cliente.listFiles();
			listado.add("DIRECTORIO ACTUAL : "+cliente.printWorkingDirectory());
			for (int i = 1; i < ficheros.length; i++) {
				cad = ficheros[i].getName();
				listado.add(cad);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listado;
	}
	
	
	public static void borrarFichero(String direc,FTPClient cliente, String nombre) {
		try {
			cliente.changeWorkingDirectory(direc);
			if(cliente.deleteFile(nombre)) {
				System.out.println("fichero eliminado con exito");
			}else {
				System.out.println("No se ha podido borrar el fichero");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void subirArchivo(FTPClient cliente,String ruta,String nombre) {
		try {
			
			BufferedInputStream in =
					new BufferedInputStream(new FileInputStream(ruta));
			try {
				cliente.setFileType(cliente.BINARY_FILE_TYPE);
				if(cliente.storeFile(nombre, in)) {
					JOptionPane.showMessageDialog(null, "Archivo subido");
					in.close();
				}else {
					JOptionPane.showMessageDialog(null, "No se puede subir el archivo");;
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
