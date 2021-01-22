package ejemplos.GUI11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui11 extends JFrame {
	Container panel;
	JButton boton1;
	JTextField campoValor, resultado;
	JLabel label1;

	public Gui11() {
		boton1 = new JButton("PULSA");
		label1 = new JLabel("Pulsaciones: 0");
		panel = getContentPane();
		panel.add(boton1);
		panel.add(label1);
		panel.setLayout(new FlowLayout());
		boton1.addActionListener(new ActionListener() {
			private int contador;

			public void actionPerformed(ActionEvent e) {
				contador++;
				label1.setText("Pulsaciones: " + contador);
			}
		});

		// setSize(400, 100);
		pack();
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui11 ventana = new Gui11();
	}

}
