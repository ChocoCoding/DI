import javax.swing.*;
import java.awt.*;


public class r_Interfaz_Racional extends JFrame{

    //1.- Creamos las variables de los componentes a utilizar
    JLabel labelNum1,labelNum2,labelDen1,labelDen2;
    JTextField textNum1,textNum2,textDen1,textDen2;
    JTextArea areaResult;
    
    JButton calc, limp;

    JPanel panelDeOperaciones, panelBotones;

    CheckboxGroup operacion;
    Checkbox suma,resta,mult,div;
    Container c;


    public r_Interfaz_Racional(){

        //2.- Inicializamos cada uno de los componentes
        c = this.getContentPane();
        c.setLayout(new GridBagLayout());

        //Labels
        labelNum1 = new JLabel("Numerador 1");
        labelNum2 = new JLabel("Numerador 2");
        labelDen1 = new JLabel("Denominador 1");
        labelDen2 = new JLabel("Denominador 2");
        
        //Text
        textNum1 = new JTextField();
        textNum2 = new JTextField();
        textDen1 = new JTextField();
        textDen2 = new JTextField();

        //Textarea
        areaResult = new JTextArea(5,5);

        //Botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        calc = new JButton("Calcular");
        limp = new JButton("Limpiar");

        //Checkbox operacion
        panelDeOperaciones = new JPanel();
        panelDeOperaciones.setLayout(new GridLayout(4,1));
        operacion = new CheckboxGroup();
        suma = new Checkbox("Suma",false,operacion);
        resta = new Checkbox("Resta",false,operacion);
        mult = new Checkbox("Multiplicacion",false,operacion);
        div = new Checkbox("Division",false,operacion);

        //Creamos las Constraints
        c.add(labelNum1, createConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4,0,0,0)));
        c.add(labelNum2, createConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4,0,0,0)));
        c.add(labelDen1, createConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4,0,0,0)));
        c.add(labelDen2, createConstraints(2, 1, 1, 1, 0, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4,0,0,0)));
        c.add(textNum1, createConstraints(1, 0, 1, 1, 1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 10)));
        c.add(textNum2, createConstraints(3,0,1,1,0.5,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 0)));
        c.add(textDen1, createConstraints(1,1,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH, new Insets(4, 0, 10, 10)));
        c.add(textDen2, createConstraints(3,1,1,1,0.5,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 0)));

        panelDeOperaciones.add(suma);
        panelDeOperaciones.add(resta);
        panelDeOperaciones.add(mult);
        panelDeOperaciones.add(div);
        panelDeOperaciones.setBorder(BorderFactory.createTitledBorder("Operacion"));
        c.add(panelDeOperaciones,createConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0,4,0,0)));

        //TEXTAREA
         // Para que se partan automaticamente las lineas al llegar al final
         areaResult.setLineWrap(true);
         areaResult.setWrapStyleWord(true);
         areaResult.setEditable(false);
         areaResult.setAutoscrolls(true);
         areaResult.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));

        JScrollPane scrollingArea = new JScrollPane(areaResult);
        c.add(areaResult, createConstraints(1,2,3,
        3,0.5,1.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(4, 1, 10, 10)));

        //BOTONES
        c.add(calc, createConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10,4,20,0)));
        c.add(limp, createConstraints(3, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST, new Insets(10,4,20,20)));
    }

    private static GridBagConstraints createConstraints(
        int gridx,
        int gridy,
        int gridwidth,
        int gridheight,
        double weightx,
        double weighty,
        int fill,
        int anchor,
        Insets insets) {
GridBagConstraints constraints = new GridBagConstraints();
constraints.gridx = gridx;
constraints.gridy = gridy;
constraints.gridwidth = gridwidth;
constraints.gridheight = gridheight;
constraints.weightx = weightx;
constraints.weighty = weighty;
constraints.fill = fill;
constraints.anchor = anchor;
constraints.insets = insets;
return constraints;
}
    


public static void main(String[] args) {
    r_Interfaz_Racional r_Interfaz_Racional = new r_Interfaz_Racional();
    r_Interfaz_Racional.setVisible(true);
    r_Interfaz_Racional.setBounds(300,600,800,400);
}
}
