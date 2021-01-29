package pSeguridad;
import java.security.Provider;
import java.security.Security;

/**
 * Programa que muestra los servicios de proveedores proporcionados por el JRE
 * 
 */

public class ProveedoresSeguridad { 
	public static void main(String args[]) {
		Provider[] providers = Security.getProviders();
		System.out.println( "Encontrados " + providers.length +
		" proveedores de seguridad. \n" ) ;
		for (Provider p:providers) {
			System.out.println(p.getInfo());
		}
	} // main
} // class ProveedoresSeguridad
