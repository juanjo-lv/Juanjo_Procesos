
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

public class Ventana1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// De esta forma el programa y el GUI con manejo de eventos se realizan en hilos diferentes
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana1() {
		JPanel contentPane;
		JTextField textField;
		JTextField textField_1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		setContentPane(contentPane);// Se añade el panel al frame
		contentPane.setLayout(null);// Esto hace que usemos un layout por defecto
		
		JLabel lblNewLabel = new JLabel("Nombre del usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(70, 67, 107, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(194, 64, 132, 20);
		contentPane.add(textField);
		//textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Clave del usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(70, 113, 107, 17);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 110, 132, 20);
		contentPane.add(textField_1);
		//textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(88, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(225, 178, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
