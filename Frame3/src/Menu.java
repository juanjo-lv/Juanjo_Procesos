import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	//private JPanel contentPane;
	private Container contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);// Establece el tamaño de la ventana
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCambiarColor = new JMenu("Cambiar color");
		menuBar.add(mnCambiarColor);//Añadimos el menu a la barra de menu
		
		// Cambiamos el fondo del panel
		JMenuItem mntmRojo = new JMenuItem("Rojo");
		mntmRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setBackground(Color.red);
			}
		});
		mnCambiarColor.add(mntmRojo);//Añadimos item de menu al menu color
		
		JMenuItem mntmVerde = new JMenuItem("Verde");
		mntmVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.green);
			}
		});
		mnCambiarColor.add(mntmVerde);//Añadimos item de menu al menu color
		
		JMenuItem mntmAzul = new JMenuItem("Azul");
		mntmAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.blue);
			}
		});
		mnCambiarColor.add(mntmAzul);

		contentPane = getContentPane();
		
		contentPane.setLayout(null);
		//contentPane.setLayout(new BorderLayout());
		
		//contentPane.setLayout(new BorderLayout(0, 0));
		/*
		 *  java.awt.BorderLayout.BorderLayout(int hgap, int vgap)

			Constructs a border layout with the specified gaps between components. The horizontal gap is specified by hgap and the vertical gap is specified by vgap.
			
			Parameters:
			hgap the horizontal gap.
			vgap the vertical gap.
		 */
		//setContentPane(contentPane);
	}

}
