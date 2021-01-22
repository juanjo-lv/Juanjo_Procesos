package ejemplos.GUI12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui12 extends JFrame {
	JButton red = new JButton("Rojo");
	JButton blue = new JButton("Azul");
	Container panel;

	public Gui12() {
		super("Color de fondo");
		panel = getContentPane();
		panel.setLayout(new FlowLayout());
		panel.add(red);
		panel.add(blue);
		red.addActionListener(new ColorActionListener(Color.red));
		blue.addActionListener(new ColorActionListener(Color.blue));
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui12 ventana = new Gui12();
	}

	class ColorActionListener implements ActionListener {
		Color fondo;

		public ColorActionListener(Color unColor) {
			fondo = unColor;
		}

		public void actionPerformed(ActionEvent evento) {
			panel.setBackground(fondo);
		}
	}
}