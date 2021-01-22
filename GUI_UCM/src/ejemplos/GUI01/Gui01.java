package ejemplos.GUI01;

import javax.swing.*;
import java.awt.*;

public class Gui01 extends JFrame {

private static final long serialVersionUID = 1L;
Container panel;
JButton miboton;
/*
 *  Para mostrar una ventana en una posición concreta disponemos del método setLocation(x, y) de la clase JFrame.
	Cuando se crea un objeto JFrame, se crea un objeto Container (AWT). El objeto JFrame usa el panel de 
	contenido (Container) para albergar los componentes del frame.

	1. Obtenemos el panel de contenido del frame:
		Container panel = this.getContentPane();

	2. Añadimos componentes a dicho panel:
		panel.add(unComponente);
*/

  public Gui01() {
    super("Ejemplo 01 con botón");
    // Configurar componentes ;
    miboton = new JButton("Aceptar");
    panel = this.getContentPane();
    panel.add(miboton);
    
    //setSize(200,100);
    setBounds(200,200,80,80);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String args[]) {
    Gui01 ventana = new Gui01();
  }
  
}