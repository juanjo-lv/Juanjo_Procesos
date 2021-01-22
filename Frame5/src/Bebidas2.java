import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// Hacemos algunas mejoras
public class Bebidas2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> cbCentimos;
	private JComboBox<String> cbEuros;
	private JLabel lResul;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bebidas2 frame = new Bebidas2();
					frame.pack();
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
	public Bebidas2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//contentPane = new JPanel();
		contentPane = this.getContentPane();// Se toma el panel del Frame 
		
		setContentPane(contentPane);
		// Para que funcione con pack(), tengo que poner un layout
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER)); // 3 filas por 2 columnas

		rb1 = new JRadioButton("Bebida 1");
		buttonGroup.add(rb1);
	
		contentPane.add(rb1);

		rb2 = new JRadioButton("Bebida 2");
		buttonGroup.add(rb2);
		
		contentPane.add(rb2);

		rb3 = new JRadioButton("Bebida 3");
		buttonGroup.add(rb3);
		
		contentPane.add(rb3);

		/*
		 *  Bebida A tiene un costo de 0 euros 80 centimos.
		 *  Bebida B tiene un costo de 1 euro 20 centimos.
		 *  Bebida C tiene un costo de 3 euros 10 centimos.
		 */
		JButton btnExtraer = new JButton("Extraer");
		btnExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int euros = Integer.parseInt((String) cbEuros.getSelectedItem());
				int centimos = Integer.parseInt((String) cbCentimos.getSelectedItem());

				System.out.println(euros);
				System.out.println(centimos);
				lResul.setText("");
				if (rb1.isSelected() && euros == 0 && centimos == 80)
					lResul.setText("Correcto");
				else if (rb2.isSelected() && euros == 1 && centimos == 20)
					lResul.setText("Correcto");
				else if (rb3.isSelected() && euros == 3 && centimos == 10)
					lResul.setText("Correcto");
				else
					lResul.setText("Incorrecto");
			}
		});

		
		contentPane.add(btnExtraer);

		lResul = new JLabel("");
		lResul.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		contentPane.add(lResul);

		cbEuros = new JComboBox<String>();
		cbEuros.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1", "2", "3", "4", "5" }));
		
		contentPane.add(cbEuros);

		cbCentimos = new JComboBox<String>();
		cbCentimos.setModel(new DefaultComboBoxModel<String>(
				new String[] { "0", "10", "20", "30", "40", "50", "60", "70", "80", "90" }));
		
		contentPane.add(cbCentimos);

		JLabel lblEuros = new JLabel("Euros");
		
		contentPane.add(lblEuros);

		JLabel lblCentimos = new JLabel("C\u00E9ntimos");
		
		contentPane.add(lblCentimos);
	}
}
