package ejemplos.GUI03b;

import javax.swing.*;
import java.awt.*;

public class Gui03b extends JFrame {
	private static final long serialVersionUID = 1L;
	Container panel;

	public Gui03b() {
		super("Ejemplo de Layout");
		// Configurar componentes:
		panel = this.getContentPane();
		// GridLayout
		panel.setLayout(new GridLayout(4, 3, 5, 5)); // filas, columnas, espacio h entre comp, espacio v entre comp
		// Add buttons to the frame
		for (int i = 1; i <= 10; i++)
			panel.add(new JButton(Integer.toString(i)));
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui03b ventana = new Gui03b();
	}
}