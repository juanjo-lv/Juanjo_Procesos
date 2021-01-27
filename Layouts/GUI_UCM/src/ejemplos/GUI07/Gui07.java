package ejemplos.GUI07;

import javax.swing.*;
import java.awt.*;

class MiPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		g.setFont(new Font("Helvetica", Font.PLAIN, 18));
		g.drawString("Hola", 70, 50);
		g.setFont(new Font("TimesRoman", Font.BOLD, 18));
		g.drawString("Hola", 70, 80);
		g.setFont(new Font("DialogInput", Font.ITALIC, 18));
		g.drawString("Hola", 70, 110);
	}
}

public class Gui07 extends JFrame {
	Container panel;

	public Gui07() {
		super("Ejemplo de dibujo");
		panel = this.getContentPane();
		panel.add(new MiPanel());
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/** Main method */
	public static void main(String[] args) {
		Gui07 ventana = new Gui07();

	}

}
