import javax.swing.JFrame;
import javax.swing.JPanel;

public class _01EscribiendoEnJava {

    public static void main(String[] args) {
        MarcoConTexto marcoConTexto = new MarcoConTexto();

    }
}

class MarcoConTexto extends JFrame{
    public MarcoConTexto(){
        setVisible(true);
        setSize(600, 450);
        setLocation(1000,300);
        setTitle("Primer texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Lamina extends JPanel{

   


}