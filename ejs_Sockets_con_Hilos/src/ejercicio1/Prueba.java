package ejercicio1;
import java.io.*;
public class Prueba {

	public static void main(String[] args) {
		File f1 = new File("archivo.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f1));
			
			System.out.println(br.readLine());
			
			File f2 = new File("mod.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(f2),true);
			
			pw.println("esto es una prueba");
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
