package layout;
import java.awt.*;
import javax.swing.*;

/**
 * Ejemplo de FlowLayout.
 * 
 */
public class FlowLayoutExample
{
    private JFrame frame;

    /**
     * Constructor for objects of class FlowLayoutExample
     */
    public FlowLayoutExample()
    {
        makeFrame();
    }

    /**
     * Place five components within a container managed by
     * a FlowLayout.
     */
    private void makeFrame()
    {
        frame = new JFrame("FlowLayout Example");
        
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        //contentPane.setLayout(new FlowLayout(FlowLayout.CENTER ));
        contentPane.add(new JButton("first"));
        contentPane.add(new JButton("second"));
        contentPane.add(new JButton("the third string is very long"));
        contentPane.add(new JButton("fourth"));
        contentPane.add(new JButton("fifth"));
        
        // A�adido
        // Con esto conseguimos que al cerrar la ventana se cierre la aplicaci�n
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.setBounds(10,  10, 400, 400);
        frame.setSize(200, 200);
        // frame.pack(); Con esta opci�n no se aprecia porque se ajusta al contenido el tama�o del frame
        frame.setVisible(true);
    }
    
    // A�adido
    /**
   	 * Launch the application.
   	 */
   	public static void main(String[] args) {
   		EventQueue.invokeLater(new Runnable() {
   			public void run() {
   				try {					
   					new FlowLayoutExample();
   				} catch (Exception e) {
   					e.printStackTrace();
   				}
   			}
   		});
   	}
}
