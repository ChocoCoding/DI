import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practica2_Swing extends JFrame {
    Container cont;

    JLabel numerador1;
    JLabel numerador2;
    JLabel denominador1;
    JLabel denominador2;
    JTextField inputNumerador1;
    JTextField inputNumerador2;
    JTextField inputDenominador1;
    JTextField inputDenominador2;
    JTextArea textArea;
    ButtonGroup buttonGroup;
    JButton calcular;
    JButton limpiar;
    GridBagConstraints restricciones;

    Practica2_Swing(){
    cont = getContentPane();
    GridBagLayout gridBag = new GridBagLayout();
    this.getContentPane().setLayout(gridBag);
    restricciones = new GridBagConstraints();
    
    numerador1 = new JLabel("Numerador1");
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(numerador1, 0, 0);


    numerador2 = new JLabel("Numerador2");
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(numerador2, 0, 1);

    denominador1 = new JLabel("Denominador1");
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(denominador1, 2, 0);


    denominador2 = new JLabel("Denominador2");
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(denominador2, 2, 1);

    inputNumerador1 = new JTextField(10);
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(inputNumerador1, 1, 0);

    inputNumerador2 = new JTextField(10);
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(inputNumerador2, 1, 1);

    inputDenominador1 = new JTextField(10);
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(inputDenominador1, 3, 0);

    inputDenominador2 = new JTextField(10);
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(inputDenominador2, 3, 1);


    textArea = new JTextArea(2,3);
    restricciones.weighty = 1.0;
    restricciones.weightx = 1.0;
    restricciones.gridwidth = 1;
    restricciones.gridheight = 1;
    addRestriccionesYCoords(textArea, 0, 3);


    buttonGroup = new ButtonGroup();
    calcular = new JButton("Calcular");
    limpiar = new JButton("Limpiar");




        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(500, 150);
    }

    private void addRestriccionesYCoords(Component c, int x, int y){
		restricciones.gridx=x;
		restricciones.gridy=y;
		add(c,restricciones);
	}



    public static void main(String args[]) {
        //GeneradorVentanas miVentana = new GeneradorVentanas("Hola Mundo",300,300,150,150);
        //GeneradorVentanas miVentana2 = new GeneradorVentanas("¿Que tal mundo?",400,400,250,150);
        //GeneradorVentanas miVentana3 = new GeneradorVentanas("Adios mundo",500,500,350,150);

        Practica2_Swing ventana1 = new Practica2_Swing();
        

    }


}
