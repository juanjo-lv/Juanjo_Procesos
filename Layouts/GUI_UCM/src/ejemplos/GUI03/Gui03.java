package ejemplos.GUI03;

import javax.swing.*;
import java.awt.*;

public class Gui03 extends JFrame {
	private static final long serialVersionUID = 1L;
	Container panel;

	public Gui03() {
		super("Ejemplo de Layout");
		// Configurar componentes:
		panel = this.getContentPane();
		// BorderLayout
		panel.setLayout(new BorderLayout(5, 10));// distancia entre componentes
		panel.add(new JButton("1"), BorderLayout.EAST);
		panel.add(new JButton("2"), BorderLayout.SOUTH);
		panel.add(new JButton("3"), BorderLayout.WEST);
		panel.add(new JButton("4"), BorderLayout.NORTH);
		panel.add(new JButton("5"), BorderLayout.CENTER);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui03 ventana = new Gui03();
	}
}