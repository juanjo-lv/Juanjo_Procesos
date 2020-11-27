package servidores;
import java.io.*;
import java.net.*;
import java.time.LocalTime;
public class HiloServHora extends Thread{
	
	private PrintWriter escribir;
	private Socket socket;
	
	public HiloServHora(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		try {
			escribir = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			int cont =0;
			
			//el servidor está dando la hora durante 40 segundos y luego se cierra
			
			while(cont<20) {
				escribir.println(LocalTime.now());
				System.out.println("***************"+LocalTime.now());
				cont++;
				sleep(2000);
			
			}
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();;
		}finally {
			
			try {
				escribir.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
