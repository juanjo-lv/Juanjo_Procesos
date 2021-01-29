package graficos;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.net.ftp.FTPClient;

import codigoFTP.Servidor;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private FTPClient cliente;
	private String servidor;
	private String user;
	private String pass;
	private ArrayList<String> listado;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App(servidor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public App(FTPClient cliente,String servidor,String user, String pass) {
		//datos
		this.cliente=cliente;
		this.servidor=servidor;
		this.user=user;
		this.pass=pass;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 529, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("Servidor FTP: "+servidor);
		label1.setBounds(10, 11, 150, 14);
		contentPane.add(label1);

		JLabel label2 = new JLabel("Usuario: "+user);
		label2.setBounds(350, 11, 117, 14);
		contentPane.add(label2);

		JLabel label3;

		label3 = new JLabel("DIRECTORIO RAIZ : /");
		label3.setBounds(10, 51, 180, 14);
		contentPane.add(label3);



		JList panel = new JList();
		panel.setBounds(10, 92, 301, 370);
		contentPane.add(panel);

		DefaultListModel modelo = new DefaultListModel();
		listado = Servidor.cambiarListarDirectorio("/", cliente);
		for(int i = 0 ; i<listado.size();i++) {
			modelo.addElement(listado.get(i));
		}
		panel.setModel(modelo);

		JButton boton3 = new JButton("Eliminar fichero");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println((String)panel.getSelectedValue());
				codigoFTP.Servidor.borrarFichero("/", cliente, (String)panel.getSelectedValue());
				modelo.clear();
				listado = Servidor.cambiarListarDirectorio("/", cliente);
				for(int i = 0 ; i<listado.size();i++) {
					modelo.addElement(listado.get(i));
				}
				
			
			
				
			}
		});
		boton3.setBounds(350, 222, 117, 36);
		contentPane.add(boton3);

		JButton boton4 = new JButton("Crear carpeta");
		boton4.setBounds(350, 295, 117, 36);
		contentPane.add(boton4);

		JButton boton1 = new JButton("Subir Fichero");
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    codigoFTP.Servidor.subirArchivo(cliente, "C:\\Users\\Zeus\\Desktop\\perro5.png","perro5.png");
				/*modelo.clear();
				listado = Servidor.cambiarListarDirectorio("/", cliente);
				for(int i = 0 ; i<listado.size();i++) {
					modelo.addElement(listado.get(i));
				}*/
			}
		});
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
