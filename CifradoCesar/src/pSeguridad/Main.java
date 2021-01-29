package pSeguridad;

public class Main {
public static void main(String[] args) {
	Cifrador c = new Cifrador();
	String cad = c.rotar("ABCDEFG", 2);
	System.out.println(cad);
	
	c.alfabetoCifrado = c.rotar(c.alfabeto, 4);
	System.out.println(c.alfabeto);
	System.out.println("\nCifrado\n");
	System.out.println(c.alfabetoCifrado);
}
}
