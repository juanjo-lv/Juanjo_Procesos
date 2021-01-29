package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.net.ftp.FTPClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 270, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Servidor:");
		label1.setBounds(34, 23, 53, 19);
		contentPane.add(label1);
		
		textField = new JTextField();
		textField.setBounds(97, 22, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel label2 = new JLabel("Usuario:");
		label2.setBounds(34, 71, 53, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Clave:");
		label3.setBounds(34, 116, 53, 14);
		contentPane.add(label3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 68, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 113, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton boton_login = new JButton("Entrar");
		boton_login.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
			    String servidor = textField.getText();
			    String user = textField_1.getText();
			    String pass = textField_2.getText();
			   
				try {
					FTPClient cliente=new FTPClient();
					cliente.connect(servidor);
					cliente.enterLocalPassiveMode();
					
					boolean login = cliente.login(user, pass);
					if(login) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Conectado correctamente","validación",JOptionPane.INFORMATION_MESSAGE);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									App frame = new App(cliente,servidor,user,pass);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
						
					}else{
						JOptionPane.showMessageDialog(null,"Error al iniciar la conexión FTP","Error crítico",JOptionPane.ERROR_MESSAGE);;
						cliente.disconnect();
						System.exit(1);
					}
					
					
				} catch (SocketException ex) {
					JOptionPane.showMessageDialog(null,"Error al iniciar la conexión FTP","Error crítico",JOptionPane.ERROR_MESSAGE);;

				 
				} catch (IOException ex) {
					
					JOptionPane.showMessageDialog(null,"Error al iniciar la conexión FTP","Error crítico",JOptionPane.ERROR_MESSAGE);;
					
				}
			    
			    
			  }


			});
		boton_login.setBounds(69, 193, 89, 23);
		contentPane.add(boton_login);
		
		


	}
}

