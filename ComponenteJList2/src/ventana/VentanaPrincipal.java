package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

//public class VentanaPrincipal extends JFrame implements ActionListener {
// Ya no hay que implementar el interfaz:
public class VentanaPrincipal extends JFrame{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contenedor;/*declaramos el contenedor*/
	private JButton agregar, eliminar, borrar;/*declaramos el objeto Boton*/
	private JLabel labelTitulo, mensaje;/*declaramos el objeto Label*/
	private JTextField campo;
	private JList<String> listaNombres;/*declaramos La Lista*/
	private DefaultListModel<String> modelo;/*declaramos el Modelo*/
	private JScrollPane scrollLista;
	
	public VentanaPrincipal(){
		/*permite iniciar las propiedades de los componentes*/
		iniciarComponentes();
   		/*Asigna un titulo a la barra de titulo*/
		setTitle("Ejemplo : JList");
		/*tama�o de la ventana*/
		setSize(280,330);
		/*pone la ventana en el Centro de la pantalla*/
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void iniciarComponentes() {
		contenedor=getContentPane();/*instanciamos el contenedor*/
		/*con esto definimos nosotros mismos los tama�os y posicion
		 * de los componentes*/
		contenedor.setLayout(null);
		
		campo= new JTextField();
		campo.setBounds(20, 80, 135, 23);
		
		
		/*Propiedades del boton, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		agregar= new JButton();
		agregar.setText("Agregar");
		agregar.setBounds(160, 80, 90, 23);
		//agregar.addActionListener(this);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarNombre();
			}
		});
		
		eliminar= new JButton();
		eliminar.setText("Eliminar");
		eliminar.setBounds(20, 210, 90, 23);
		//eliminar.addActionListener(this);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarNombre(listaNombres.getSelectedIndex() );
			}
		});
		
		borrar= new JButton();
		borrar.setText("Borrar Lista");
		borrar.setBounds(120, 210, 110, 23);
		//borrar.addActionListener(this); // Todos los listener entran por el mismo m�todo
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarLista();
			}
		});
		
		/*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		labelTitulo= new JLabel();
		labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 28));
		labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTitulo.setText("JList");
		labelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		labelTitulo.setBounds(40, 20, 180, 43);
		
		mensaje= new JLabel();
		mensaje.setBounds(20, 250, 280, 23);
		
		//instanciamos la lista
		listaNombres = new JList<String>();
		listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		//instanciamos el modelo
		modelo = new DefaultListModel<String>();
	   	
		//instanciamos el Scroll que tendra la lista
	    scrollLista = new JScrollPane();
		scrollLista.setBounds(20, 120,220, 80);
	    scrollLista.setViewportView(listaNombres);
		
		/*Agregamos los componentes al Contenedor*/
		contenedor.add(labelTitulo);
		contenedor.add(campo);
		contenedor.add(agregar);
		contenedor.add(eliminar);
		contenedor.add(borrar);
		contenedor.add(mensaje);
		contenedor.add(scrollLista);
		//contenedor.add(botonCam);
	}

/*
	Sustituimos este metodo por individuales para cada componente
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==agregar)
		{
			agregarNombre();
			mensaje.setText("Se agreg� un nuevo elemento");
		}
		if (evento.getSource()==eliminar)
		{
			eliminarNombre(listaNombres.getSelectedIndex() );
		}
		if (evento.getSource()==borrar)
		{
			borrarLista();
			mensaje.setText("Se borr� toda la lista");
		}
	}
*/
	

	
	private void agregarNombre() {
		String nombre=campo.getText();
		
		modelo.addElement(nombre);
		listaNombres.setModel(modelo);// Cada vez que se a�ade un elemento
		campo.setText("");
	}
	
	private void eliminarNombre(int indice) {
		if (indice>=0) {
			modelo.removeElementAt(indice);	
			mensaje.setText("Se elimin� un elemento en la posici�n "+indice);
		} else{
			JOptionPane.showMessageDialog(null, "Debe seleccionar un indice"
					,"Error", JOptionPane.ERROR_MESSAGE);
			
			mensaje.setText("NO se seleccion� ning�n elemento");
		}
		
	}
	
	private void borrarLista() {
		modelo.clear();
	}

}