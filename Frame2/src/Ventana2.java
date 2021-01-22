//import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana2 extends JFrame {

	private static final long serialVersionUID = -2545433418724084780L;
	//private JPanel contentPane;
	private Container contentPane;
	private JTextField sum1;
	private JTextField sum2;
	private JLabel resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { // Llama a invokeLater de EventQueue
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = this.getContentPane();// Se toma el panel del Frame 
		
		//contentPane = new JPanel(); 
		
		// Todo lo comentado era del original, lo otro es una prueba
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		
		contentPane.setLayout(null);// Esto hace que usemos un layout por defecto
		
		JLabel lblNewLabel = new JLabel("Introduzca primer valor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 67, 132, 14);
		contentPane.add(lblNewLabel);
		
		sum1 = new JTextField();
		sum1.setBounds(216, 65, 132, 20);
		contentPane.add(sum1);
		sum1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca segundo valor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(45, 113, 143, 17);
		contentPane.add(lblNewLabel_1);
		
		sum2 = new JTextField();
		sum2.setBounds(216, 112, 132, 20);
		contentPane.add(sum2);
		sum2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sumar");
		
		// Ahora añadimos acciones a los botones
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int v1=Integer.parseInt(sum1.getText());
	            int v2=Integer.parseInt(sum2.getText());
	            int suma=v1+v2;
	            resultado.setText(String.valueOf(suma));
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(126, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		resultado = new JLabel("Resultado");
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resultado.setBounds(256, 182, 70, 19);
		
		
		contentPane.add(resultado);

	}
}
