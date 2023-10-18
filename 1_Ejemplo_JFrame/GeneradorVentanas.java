import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeneradorVentanas extends JFrame {
    JPanel miPanel;
    JTextField texto1;
    JLabel label1;
    JCheckBox checkbox1;
    JButton boton1;


     GeneradorVentanas(String titulo,int alto, int ancho, int posX, int posY) {
        super(titulo);

        texto1 = new JTextField(20);
        label1 = new JLabel("Introduce tu nombre: ");
        checkbox1 = new JCheckBox("Acepta la politica de privacidad: ");
        boton1 = new JButton("Enviar");


        miPanel = new JPanel();

        miPanel.setLayout(new BoxLayout(miPanel, BoxLayout.Y_AXIS));

        miPanel.add(label1,FlowLayout.LEFT);
        miPanel.add(texto1,FlowLayout.CENTER);
        miPanel.add(checkbox1,FlowLayout.LEFT);
        miPanel.add(boton1,FlowLayout.LEFT);


        
        setSize(ancho,alto);
       // setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(posX, posY);
        setContentPane(miPanel);

    }
    
    GeneradorVentanas(String titulo,int alto, int ancho) {
        super(titulo);

        GridBagLayout gridBag = new GridBagLayout();
        this.getContentPane().setLayout(gridBag);
        GridBagConstraints restricciones = new GridBagConstraints();

        label1 = new JLabel("Introduce un texto cualquiera: ");
        label1.setHorizontalAlignment(JLabel.CENTER);
        restricciones.fill=GridBagConstraints.HORIZONTAL;
        restricciones.insets = new java.awt.Insets(-10, 0, 0, 0);
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.weighty = 1.0;


;
        getContentPane().add(label1, restricciones);


        texto1 = new JTextField(32);
        texto1.setText("hola que ase");
        restricciones.fill=GridBagConstraints.HORIZONTAL;
        restricciones.insets = new java.awt.Insets(-40, 0, 0, 0);
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.weighty = 1.0;
        restricciones.weightx = 1.0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        getContentPane().add(texto1, restricciones);

        checkbox1 = new JCheckBox("Convertir el texto a mayúsculas: ");
        restricciones.fill=GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.weighty = 1.0;
        restricciones.weightx=1.0;
        restricciones.insets = new java.awt.Insets(-60, -150, 0, 0);
       

        getContentPane().add(checkbox1, restricciones);
        setSize(ancho,alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        //GeneradorVentanas miVentana = new GeneradorVentanas("Hola Mundo",300,300,150,150);
        //GeneradorVentanas miVentana2 = new GeneradorVentanas("¿Que tal mundo?",400,400,250,150);
        //GeneradorVentanas miVentana3 = new GeneradorVentanas("Adios mundo",500,500,350,150);

        GeneradorVentanas miVentana4 = new GeneradorVentanas("Ejemplo de uso con JCheckBox",200,400);
        

    }
}
