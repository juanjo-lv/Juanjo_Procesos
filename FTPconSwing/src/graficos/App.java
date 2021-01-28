package graficos;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 529, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Servidor FTP:");
		label1.setBounds(10, 11, 129, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Usuario:");
		label2.setBounds(350, 11, 117, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("DIRECTORIO RAIZ: /");
		label3.setBounds(10, 51, 117, 14);
		contentPane.add(label3);
		
		JTextPane panel = new JTextPane();
		panel.setBounds(10, 92, 301, 370);
		contentPane.add(panel);
		
		JButton boton3 = new JButton("Eliminar fichero");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boton3.setBounds(350, 222, 117, 36);
		contentPane.add(boton3);
		
		JButton boton4 = new JButton("Crear carpeta");
		boton4.setBounds(350, 295, 117, 36);
		contentPane.add(boton4);
		
		JButton boton1 = new JButton("Subir Fichero");
		boton1.setBounds(350, 92, 117, 36);
		contentPane.add(boton1);
		
		JButton boton2 = new JButton("Descargar fichero");
		boton2.setBounds(350, 159, 117, 36);
		contentPane.add(boton2);
		
		JButton boton5 = new JButton("Eliminar carpeta");
		boton5.setBounds(350, 359, 117, 36);
		contentPane.add(boton5);
		
		JButton boton6 = new JButton("Salir");
		boton6.setBounds(350, 426, 117, 36);
		contentPane.add(boton6);
	}
}
