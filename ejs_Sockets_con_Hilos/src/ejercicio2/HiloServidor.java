package ejercicio2;
import java.net.*;
import java.io.*;

public class HiloServidor extends Thread{
	

	private Socket miSocket;
	private int numServ;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public HiloServidor() {
		
	}
	public HiloServidor(Socket miSocket, int numServ) {
		this.miSocket=miSocket;
		this.numServ=numServ;
	}

	public void run() {
		try {
			String rutaDestino="ejercicio2_archivos/foto"+numServ+".jpeg";
			File f = new File(rutaDestino);
			dis = new DataInputStream((miSocket.getInputStream()));
			dos = new DataOutputStream(new FileOutputStream(f));
			
			String rutaOrigen = dis.readUTF();
			
			copyFile(rutaOrigen, rutaDestino);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public static void copyFile(String origen, String destino) {
        File f1 = new File(origen);
        File f2 = new File(destino);
        if (f1.exists()) {
            try {
                InputStream in = new FileInputStream(f1);
                OutputStream out = new FileOutputStream(f2);

                byte[] img = new byte[260917];
                int longitud;
                while ((longitud = in.read(img)) > 0) {
                    out.write(img, 0, longitud);
                }
                in.close();
                out.close();
                
            } catch (IOException ioe) {
                ioe.printStackTrace();
                
            }
        } else {
             System.out.println("El archivo que quieres replicar no existe");
        }
    }
}