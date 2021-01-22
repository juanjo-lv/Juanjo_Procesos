package principal;

import java.awt.EventQueue;

import ventana.VentanaPrincipal;

public class Principal {
	
	public static void main(String[] args) {
		// Creo un hilo nuevo para ejecutar el interfaz
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*Declaramos el objeto*/
					VentanaPrincipal miVentanaPrincipal;
					
					/*Instanciamos el objeto*/
					miVentanaPrincipal= new VentanaPrincipal();
				
					miVentanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
