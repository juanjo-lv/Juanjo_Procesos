package codigoFTP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
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
			for (int i = 0; i < ficheros.length; i++){
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
				JOptionPane.showMessageDialog(null,"fichero eliminado con exito");

			}else {
				JOptionPane.showMessageDialog(null,"No se ha podido borrar el fichero" , "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void subirArchivo(FTPClient cliente,File fich) {
		try {

			BufferedInputStream in =
					new BufferedInputStream(new FileInputStream(fich));
			try {
				cliente.setFileType(cliente.BINARY_FILE_TYPE);
				if(cliente.storeFile(fich.getName(), in)) {
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
	public static void crearCarpeta(FTPClient cliente) {
		String nombreCarpeta;

		nombreCarpeta=JOptionPane.showInputDialog("Nombre de la carpeta que quieres crear");
		try {
			if (cliente.makeDirectory(nombreCarpeta)) {
				System.out.println("Directorio :  " + 
						nombreCarpeta + " creado ...");

			} else {
				System.out.println("No se ha podido crear el Directorio");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void borrarCarpeta(String direc,FTPClient cliente, String nombre) {
		try {
			cliente.changeWorkingDirectory(direc);
			if(cliente.removeDirectory(nombre)) {
				JOptionPane.showMessageDialog(null,"Carpeta eliminada con exito");

			}else {
				JOptionPane.showMessageDialog(null,"No se ha podido borrar la carpeta" , "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void descFichero(FTPClient cliente,String nombre,String nombrefich) {
		File file;
		String archivoyCarpetaDestino="";
		String carpetaDestino ="";
		
		JFileChooser f = new JFileChooser();
		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		f.setDialogTitle("Selecciona el directorio donde DESCARGAR el fichero");
		
		int returnVal = f.showDialog(null, "Descargar");
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = f.getSelectedFile();
			carpetaDestino = (file.getAbsolutePath()).toString();
			archivoyCarpetaDestino = carpetaDestino+ File.separator+nombrefich;
			try {
				cliente.setFileType(cliente.BINARY_FILE_TYPE);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(archivoyCarpetaDestino));
				if(cliente.retrieveFile(nombre, out)) {
					JOptionPane.showMessageDialog(null, "Archivo descargado con exito");
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido descargar el archivo","Error",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

