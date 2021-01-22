package ejemplos.GUI09_1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

//Ya no hay que implementar el interfaz ActionListener:
public class Gui09_1 extends JFrame {
  JButton boton;
  Container panel;
  public Gui09_1() {
    panel = this.getContentPane();
    boton = new JButton("Pulsa!");
    panel.add(boton);
    
    //boton.addActionListener(new OyenteBoton());
    
    boton.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		    Toolkit.getDefaultToolkit().beep();
    		    Toolkit.getDefaultToolkit().beep();
    		  }
    });

    
    setSize(100, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
 
  /** Main method */
  public static void main(String[] args) {
    Gui09_1 ventana = new Gui09_1();
      
  }
  
}

//Esto ya no me hace falta:
/*
 * 
class OyenteBoton implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    Toolkit.getDefaultToolkit().beep();
	  }
}
 */


