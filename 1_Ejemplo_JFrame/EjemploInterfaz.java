import javax.swing.*;

public class EjemploInterfaz extends JFrame {

    // Declaracion de propiedades de la interface
    JPanel miPanel;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JTextField texto1;
    JLabel label1;
    JCheckBox checkbox1;

    // Constructor de la ventana
    EjemploInterfaz() {
        miPanel = new JPanel();
        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Este es el boton 2");
        boton3 = new JButton("Boton 3");
        texto1 = new JTextField(20);
        label1 = new JLabel("Introduce tu nombre: ");
        checkbox1 = new JCheckBox("Acepta la politica de privacidad: ");
        miPanel.add(boton1);
        miPanel.add(boton2);
        miPanel.add(boton3);
        miPanel.add(label1);
        miPanel.add(texto1);
        miPanel.add(checkbox1);

        
        setContentPane(miPanel);
        setSize(350, 150);
        setTitle("Prueba de FlowLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        EjemploInterfaz miVentana = new EjemploInterfaz();

    }
}
