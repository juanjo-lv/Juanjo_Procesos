package servidor;
import java.net.*;
import java.io.*;
public class HiloServidor extends Thread{
	
	private Socket con_cliente1;
	private Socket con_cliente2;
	
	private BufferedReader lectura;
	private BufferedReader lectura2;
	
	private PrintWriter escribir;
	private PrintWriter escribir2;
	
	private int cont;
	
	public HiloServidor(Socket con_cliente1,Socket con_cliente2,int cont) {
		this.con_cliente1=con_cliente1;
		this.con_cliente2=con_cliente2;
		this.cont=cont;
	}
	public void run() {
		System.out.println("Bienvenido a la Sala nº"+cont);
		
		try {
			lectura = new BufferedReader(new InputStreamReader(con_cliente1.getInputStream()));
			lectura2 = new BufferedReader(new InputStreamReader(con_cliente2.getInputStream()));
			escribir = new PrintWriter(new OutputStreamWriter(con_cliente1.getOutputStream()),true);
			escribir2 = new PrintWriter(new OutputStreamWriter(con_cliente2.getOutputStream()),true);
			
			String msg=" ";	
			
			while(!msg.equalsIgnoreCase(".")) {	
				
				msg = lectura.readLine();
				
				escribir2.println(msg);
					
				msg = lectura2.readLine();
					
				escribir.println(msg);
				
			}
			
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				lectura.close();
				lectura2.close();
				escribir.close();
				escribir2.close();
				
				System.out.println("sala nº"+cont+" cerrada");
				con_cliente1.close();
				con_cliente2.close();
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
