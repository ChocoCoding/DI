import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

public class Ventana extends JFrame{

    //Definimos los componentes
    JTextArea areaTexto;
    JButton boton1,boton2,boton3,boton4;
    JTextField cajaTexto;
    Content c;

    public Ventana(){
        //Escribimos el titulo de nuestra ventana
        super("Prueba GridBagLayout");
        //Establecemos el layout del Panel de JFrame
        this.getContentPane().setLayout(new GridBagLayout());

        //Creamos las restricciones
        GridBagConstraints restricciones = new GridBagConstraints();

        areaTexto = new JTextArea("Introduce el texto");
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 2;
        restricciones.gridheight = 2;
        // El area de texto debe estirarse en ambos sentidos.
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weighty = 1.0;
        this.getContentPane().add(areaTexto,restricciones);
        restricciones.weighty = 0.0;
 

        boton1 = new JButton("Boton 1");
        restricciones.gridx = 2;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        restricciones.weighty = 1.0;
        //Indicar que ocupe la posicion NORTE
        restricciones.anchor = GridBagConstraints.NORTH;
        // El botón 1 no debe estirarse. Habíamos cambiado este valor en el
        // area de texto, asi que lo restauramos.
        restricciones.fill = GridBagConstraints.NONE;
        this.getContentPane().add(boton1,restricciones);
        restricciones.anchor = GridBagConstraints.CENTER;
        restricciones.weighty = 0.0;

        boton2 = new JButton("Boton 2");
        restricciones.gridx = 2;
        restricciones.gridy = 1;
         restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        restricciones.weighty = 1.0;
        restricciones.anchor = GridBagConstraints.NORTH;
        this.getContentPane().add(boton2,restricciones);
        restricciones.weighty = 0.0;
        restricciones.anchor = GridBagConstraints.CENTER;


        boton3 = new JButton("Boton 3");
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        this.getContentPane().add(boton3,restricciones);
    

        boton4 = new JButton("Boton 4");
        restricciones.gridx = 2;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        this.getContentPane().add(boton4,restricciones);

        cajaTexto = new JTextField("Introduce el texto");
        restricciones.gridx = 1;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add(cajaTexto,restricciones);
    }


    public static void main(String args[]) {
        Ventana miVentana = new Ventana();
        miVentana.setSize(300, 200);
        miVentana.setVisible(true);
    }
    
}
