package ejemplos.GUI00;

import javax.swing.*;

public class Gui00 extends JFrame {
  /**
	 * Ejemplos del powerpoint Tema9(JavaUCM)
  */
private static final long serialVersionUID = 1L;

/*
 *  Para mostrar una ventana en una posici�n concreta disponemos del m�todo setLocation(x, y) de la clase JFrame.
	Cuando se crea un objeto JFrame, se crea un objeto Container (AWT). El objeto JFrame usa el panel de 
	contenido (Container) para albergar los componentes del frame.

	1. Obtenemos el panel de contenido del frame:
		Container panel = this.getContentPane();

	2. A�adimos componentes a dicho panel:
		panel.add(unComponente);
*/

  public Gui00() {
    super("Ejemplo 01 con bot�n"); // Constructor del JFrame
   
    setSize(200,100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String args[]) {
    Gui00 ventana = new Gui00();
  }
  
}