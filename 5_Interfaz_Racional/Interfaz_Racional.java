import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz_Racional extends JFrame {

        JLabel JLnumerador1;
        JLabel JLnumerador2;
        JLabel JLdenominador1;
        JLabel JLdenominador2;

        JTextField JTFnum1, JTFnum2, JTFden1, JTFden2;

        JButton JBcalc, JBlimp;

        JTextArea JTAresultado;

        JPanel panelOperaciones;

        CheckboxGroup operacion;
        Checkbox CHBsuma;
        Checkbox CHBresta;
        Checkbox CHBmultiplicacion;
        Checkbox CHBdivision;

        // Constructor de la interfaz
        public Interfaz_Racional() {
                JLnumerador1 = new JLabel("Numerador1");
                // Pongo este código para comprobar lo que ocupa la etiqueta
                JLnumerador1.setOpaque(true);
                JLnumerador1.setBackground(Color.WHITE);

                JLnumerador2 = new JLabel("Numerador2");
                JLnumerador2.setOpaque(true);
                JLnumerador2.setBackground(Color.WHITE);

                JLdenominador1 = new JLabel("Denominador1");
                JLdenominador1.setOpaque(true);
                JLdenominador1.setBackground(Color.WHITE);

                JLdenominador2 = new JLabel("Denominador2");
                JLdenominador2.setOpaque(true);
                JLdenominador2.setBackground(Color.WHITE);

                JTFnum1 = new JTextField();
                JTFnum2 = new JTextField();
                JTFden1 = new JTextField();
                JTFden2 = new JTextField();

                JBcalc = new JButton("Calcular");
                JBlimp = new JButton("Limpiar");

                JTAresultado = new JTextArea(5, 5);

                panelOperaciones = new JPanel();

                operacion = new CheckboxGroup();
                CHBsuma = new Checkbox("Suma", false, operacion);
                CHBresta = new Checkbox("Resta", false, operacion);
                CHBmultiplicacion = new Checkbox("Multipliacion", false, operacion);
                CHBdivision = new Checkbox("Division", false, operacion);

                // Asignar un nuevo layout al JFrame
                this.setLayout(new GridBagLayout());

                this.getContentPane().add(JLnumerador1, createConstraints(0,0,1,
                1,0,1.0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,
                new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFnum1,createConstraints(1,0,1,1, 
                1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 1)));

                this.getContentPane().add(JLnumerador2,createConstraints(2,0,1,1,
                0.5,1.0,GridBagConstraints.NONE,GridBagConstraints.NORTH, new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFnum2,createConstraints(3,0,1,1,0.5,1.0,
                GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 4)));

                this.getContentPane().add(JLdenominador1,createConstraints(0,1,1,1,
                0,1.0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFden1,createConstraints(1,1,1,1,1.0,
                1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH, new Insets(4, 0, 10, 5)));

                this.getContentPane().add(JLdenominador2,createConstraints(2,1,1,1,
                0.5,1.0,GridBagConstraints.NONE,GridBagConstraints.NORTH,new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFden2,createConstraints(3,1,1,1,0.5,1.0,
                GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH,new Insets(4, 0, 10, 4)));
              
                // Para que se partan automaticamente las lineas al llegar al final
                JTAresultado.setLineWrap(true);
                JTAresultado.setWrapStyleWord(true);
                JTAresultado.setEditable(false);
                JTAresultado.setAutoscrolls(true);
                JTAresultado.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));

                JScrollPane scrollingArea = new JScrollPane(JTAresultado);
                this.getContentPane().add(JTAresultado,createConstraints(1,2,3,
                3,0.5,1.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(4, 1, 10, 10)));

                panelOperaciones.setLayout(new GridLayout(4, 1));
                panelOperaciones.setBorder(BorderFactory.createTitledBorder("Operacion"));

                panelOperaciones.add(CHBsuma);
                panelOperaciones.add(CHBresta);
                panelOperaciones.add(CHBmultiplicacion);
                panelOperaciones.add(CHBdivision);

                this.getContentPane().add(panelOperaciones,createConstraints(0,3,1,3,
                1.0,1.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(4, 1, 10, 10)));
                this.getContentPane().add(JBcalc,createConstraints(0,6,1,1,1.0,
                1.0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(4, 10, 10, 4)));JBcalc.setEnabled(false); // Poner el bot�n de calcular desactivado hasta elegir una operacion

                this.getContentPane().add(JBlimp,createConstraints(3,6,1,1,1.0,
                1.0,GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,new Insets(4, 1, 10, 10)));
        }

        // Método private para asignar las restricciones de cada componente
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
                Interfaz_Racional ventana = new Interfaz_Racional();
                ventana.setTitle("Operación Racional");
                ventana.setSize(800, 400);
                ventana.setVisible(true);
        }
}
