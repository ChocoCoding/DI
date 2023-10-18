import java.awt.event.InputMethodListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.VetoableChangeListener;

import javax.swing.JFrame;

public class VentanaAdapter extends JFrame {
    // constructores
    public VentanaAdapter() {
        super();
        setSize(500, 500);
    }

    public VentanaAdapter(String title) {
        super(title);
        setSize(500, 500);

        CerrarVentana cv = new CerrarVentana();
        this.addWindowListener(cv);
    }

    public static void main(String[] args) {
        VentanaAdapter miVentana = new VentanaAdapter("Ventana de Prueba");
        miVentana.setVisible(true);
    }
    
    class CerrarVentana extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.out.println("La ventana está cerrando");
            System.exit(0);

        }
        public void windowActivated(WindowEvent e){
            System.out.println("La ventana se ha activado");
        }

    }
}
