import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ascensor extends JFrame {

	private Container contentPane;
	private JLabel l2;
	private JLabel l1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ascensor frame = new Ascensor();
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
	public Ascensor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);*/
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pisoactual=Integer.parseInt(l1.getText());
				if (pisoactual<4)
                    l2.setText("Sube");
                else
                    l2.setText("Piso actual");                
                l1.setText("4"); 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(26,13, 89, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pisoactual=Integer.parseInt(l1.getText());
                if (pisoactual>3)
                    l2.setText("Baja");
                else if (pisoactual<3)
                    l2.setText("Sube");   
                else                
                    l2.setText("Piso actual");                
                l1.setText("3");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(26, 73, 89, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pisoactual=Integer.parseInt(l1.getText());
                if (pisoactual>2)
                    l2.setText("Baja");
                else if (pisoactual<2)
                    l2.setText("Sube");   
                else                
                    l2.setText("Piso actual");                
                l1.setText("2");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(26, 135, 89, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("1");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pisoactual=Integer.parseInt(l1.getText());
                if (pisoactual>1)
                    l2.setText("Baja");                
                else                
                    l2.setText("Piso actual");                
                l1.setText("1");
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(26, 195, 89, 51);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Piso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(169, 91, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(169, 151, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		l1 = new JLabel("1");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(305, 91, 46, 14);
		contentPane.add(l1);
		
		l2 = new JLabel("");
		l2.setBounds(305, 151, 69, 14);
		contentPane.add(l2);
	}
}
