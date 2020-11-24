package ejercicio2;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Prueba {

	public static void main(String[] args) {
		File f = new File("ejercicio2_archivos/foto.jpeg");
		File f2= new File("ejercicio2_archivos/foto2.jpeg");
		 Prueba p = new Prueba();
	        boolean result = p.copyFile("ejercicio2_archivos/foto.jpeg", "ejercicio2_archivos/foto2.jpeg");
	        System.out.println(result?
	            "Success! File copying (Éxito! Fichero copiado)":
	                "Error! Failed to copy the file (Error! No se ha podido copiar el fichero)");
	}
    public boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                // We use a buffer for the copy (Usamos un buffer para la copia).
                byte[] buf = new byte[260917];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean moveFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                byte[] buf = new byte[260917];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return origin.delete();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean moveFileSimple(String fromFile, String toFile) {
        File origen = new File(fromFile);
        return origen.renameTo(new File(toFile));
    }
}
