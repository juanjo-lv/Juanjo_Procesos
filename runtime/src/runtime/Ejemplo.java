package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo {

	public static void main(String[] args) {
		Process p = null;
		
		Runtime r = Runtime.getRuntime();
		String cad ="cmd /c dir";
		try {
			p = r.exec(cad);
			BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea="";
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
