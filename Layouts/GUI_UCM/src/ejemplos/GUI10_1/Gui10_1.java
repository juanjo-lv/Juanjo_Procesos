package ejemplos.GUI10_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui10_1 extends JFrame {
	Container panel;
	JButton botonCopiar;
	JTextField campoValor, resultado;

	public Gui10_1() {
		panel = getContentPane();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("Valor "));
		campoValor = new JTextField(5);
		panel.add(campoValor);
		botonCopiar = new JButton("Copiar");
		panel.add(botonCopiar);
		
		botonCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = campoValor.getText();
				resultado.setText(valor);
			}
		});
		
		panel.add(new JLabel("          Copia "));
		resultado = new JTextField(6);
		panel.add(resultado);
		setSize(400, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui10_1 ventana = new Gui10_1();
	}

	
}
