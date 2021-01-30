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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
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
		setBounds(650, 200, 596, 545);
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

		//Lista lo que hay por defecto en el directorio principal

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
				try {
					codigoFTP.Servidor.borrarFichero(cliente.printWorkingDirectory(), cliente, (String)panel.getSelectedValue());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				modelo.clear();
				listado = Servidor.cambiarListarDirectorio("/", cliente);
				for(int i = 0 ; i<listado.size();i++) {
					modelo.addElement(listado.get(i));
				}	
			}
		});
		boton3.setBounds(350, 265, 160, 36);
		contentPane.add(boton3);

		JButton boton4 = new JButton("Crear carpeta");
		boton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				codigoFTP.Servidor.crearCarpeta(cliente);	
				modelo.clear();
				try {
					listado = Servidor.cambiarListarDirectorio(cliente.printWorkingDirectory(), cliente);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 0 ; i<listado.size();i++) {
					modelo.addElement(listado.get(i));
				}
			}

		});
		boton4.setBounds(350, 325, 160, 36);
		contentPane.add(boton4);


		JButton boton1 = new JButton("Subir Fichero");
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				abrir();
				modelo.clear();
				try {
					listado = Servidor.cambiarListarDirectorio(cliente.printWorkingDirectory(), cliente);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 0 ; i<listado.size();i++) {
					modelo.addElement(listado.get(i));
				}	
			}
		});
		

		boton1.setBounds(350, 141, 160, 36);
		contentPane.add(boton1);

		JButton boton2 = new JButton("Descargar fichero");
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				codigoFTP.Servidor.descFichero(cliente, (String)panel.getSelectedValue(),(String)panel.getSelectedValue());
				
				
				
			}
			
		});
		boton2.setBounds(350, 204, 160, 36);
		contentPane.add(boton2);

		JButton boton5 = new JButton("Eliminar carpeta");
		boton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					codigoFTP.Servidor.borrarCarpeta(cliente.printWorkingDirectory(), cliente,(String)panel.getSelectedValue());
					modelo.clear();
					listado = Servidor.cambiarListarDirectorio("/", cliente);
					for(int i = 0 ; i<listado.size();i++) {
						modelo.addElement(listado.get(i));
					}	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		boton5.setBounds(350, 383, 160, 36);
		contentPane.add(boton5);

		JButton boton6 = new JButton("Salir");
		boton6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		boton6.setBounds(350, 442, 160, 36);
		contentPane.add(boton6);

		JButton boton7 = new JButton("Mover a...");
		boton7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(cliente.changeWorkingDirectory((String)panel.getSelectedValue())) {
						JOptionPane.showMessageDialog(null, "Te has movido a "+cliente.printWorkingDirectory()+" con exito");
						modelo.clear();
						listado = Servidor.cambiarListarDirectorio(cliente.printWorkingDirectory(), cliente);
						for(int i = 0 ; i<listado.size();i++) {
							modelo.addElement(listado.get(i));
						}	
					}else{
						JOptionPane.showMessageDialog(null, "No te has podido mover de carpeta","error",JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		boton7.setBounds(350, 82, 160, 36);
		contentPane.add(boton7);

		JButton retroceder = new JButton("");
		ImageIcon icono = new ImageIcon("flecha.jpg");
		retroceder.setIcon(icono);
		retroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.changeWorkingDirectory("../");
					JOptionPane.showMessageDialog(null, "Te has movido a "+cliente.printWorkingDirectory()+" con exito");

					modelo.clear();
					listado = Servidor.cambiarListarDirectorio(cliente.printWorkingDirectory(), cliente);
					for(int i = 0 ; i<listado.size();i++) {
						modelo.addElement(listado.get(i));
					}	

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		retroceder.setBounds(271, 51, 40, 40);
		contentPane.add(retroceder);
	}
	public void abrir() {
		JFileChooser file=new JFileChooser();
		file.showOpenDialog(this);
		File archivo=file.getSelectedFile();
		codigoFTP.Servidor.subirArchivo(cliente, archivo);

	}

}
