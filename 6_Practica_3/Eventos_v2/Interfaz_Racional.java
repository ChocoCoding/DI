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

        // Declara tres objetos de tipo racional

        Racional2 numero1;
        Racional2 numero2;
        Racional2 resultado;

        // Declara una variable de tipo String para la operacion con el valor por
        // defecto
        // del checkbox que se encuentra seleccionado
        String op = "";

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

                // Crea tres objetos de tipo racional vacios
                numero1 = new Racional2();
                numero2 = new Racional2();
                resultado = new Racional2();

                // Asignar un nuevo layout al JFrame
                this.setLayout(new GridBagLayout());

                this.getContentPane().add(JLnumerador1, createConstraints(0, 0, 1,
                                1, 0, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                                new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFnum1, createConstraints(1, 0, 1, 1,
                                1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH,
                                new Insets(4, 0, 10, 1)));

                this.getContentPane().add(JLdenominador1, createConstraints(2, 0, 1, 1,
                                0.5, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTH, new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFnum2, createConstraints(3, 0, 1, 1, 0.5, 1.0,
                                GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 4)));

                this.getContentPane().add(JLnumerador2, createConstraints(0, 1, 1, 1,
                                0, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                                new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFden1, createConstraints(1, 1, 1, 1, 1.0,
                                1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 5)));

                this.getContentPane().add(JLdenominador2, createConstraints(2, 1, 1, 1,
                                0.5, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTH, new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFden2, createConstraints(3, 1, 1, 1, 0.5, 1.0,
                                GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 4)));

                // Para que se partan automaticamente las lineas al llegar al final
                JTAresultado.setLineWrap(true);
                JTAresultado.setWrapStyleWord(true);
                JTAresultado.setEditable(false);
                JTAresultado.setAutoscrolls(true);
                JTAresultado.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));

                JScrollPane scrollingArea = new JScrollPane(JTAresultado);
                this.getContentPane().add(JTAresultado, createConstraints(1, 2, 3,
                                3, 0.5, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                                new Insets(4, 1, 10, 10)));

                panelOperaciones.setLayout(new GridLayout(4, 1));
                panelOperaciones.setBorder(BorderFactory.createTitledBorder("Operacion"));

                panelOperaciones.add(CHBsuma);
                panelOperaciones.add(CHBresta);
                panelOperaciones.add(CHBmultiplicacion);
                panelOperaciones.add(CHBdivision);

                this.getContentPane().add(panelOperaciones, createConstraints(0, 3, 1, 3,
                                1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                                new Insets(4, 1, 10, 10)));
                this.getContentPane().add(JBcalc, createConstraints(0, 6, 1, 1, 1.0,
                                1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4, 10, 10, 4)));
                JBcalc.setEnabled(false); // Poner el bot�n de calcular desactivado hasta elegir una operacion

                this.getContentPane().add(JBlimp, createConstraints(3, 6, 1, 1, 1.0,
                                1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHEAST, new Insets(4, 1, 10, 10)));

                // Poner los botones a la escucha
                JBlimp.addActionListener(new OyenteAccion());
                JBcalc.addActionListener(new OyenteAccion());

                // Poner los botones de opcion a la escucha

                CHBsuma.addItemListener(new OyentoBotonOpcion());
                CHBresta.addItemListener(new OyentoBotonOpcion());
                CHBmultiplicacion.addItemListener(new OyentoBotonOpcion());
                CHBdivision.addItemListener(new OyentoBotonOpcion());

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

        // Declaracion de un metodo para limpiar los cuadros de texto

        public void limpiar() {
                JTFnum1.setText("");
                JTFnum2.setText("");
                JTFden1.setText("");
                JTFden2.setText("");
                JTAresultado.setText("");
                JBcalc.setEnabled(false);

                // Limpia las opciones de los botones de opci�n

                CHBsuma.setState(false);
                CHBresta.setState(false);
                CHBmultiplicacion.setState(false);
                CHBdivision.setState(false);
                System.out.println(CHBsuma.getState());

                // Posiciona el foco del raton en el cuadro de texto

                JTFnum1.requestFocus();

        }

        // Declaracion de un metodo para convertir un string en un entero
        static int obtenerValor(String texto) {
                try {
                        return Integer.parseInt(texto);
                } catch (NumberFormatException e) {
                        return 0;
                }
        }

        //

        // Implementación en la clase oyente
        class OyenteAccion implements ActionListener {
                // Cuando se pinche en el botón
                public void actionPerformed(ActionEvent evento) {
                        // Obtener el botón que disparó el evento
                        JButton botón = (JButton) evento.getSource();
                        String comando = evento.getActionCommand();
                        if (comando.equals("Calcular")) {

                                JTAresultado.setText(JTAresultado.getText() + numero1.devolverNumerador() + " / "
                                                + numero1.devolverDenominador() + op + numero2.devolverNumerador()
                                                + " / "
                                                + numero2.devolverDenominador() + " = " + resultado.devolverNumerador()
                                                + "/"
                                                + resultado.devolverDenominador() + "\n");
                                JBcalc.setEnabled(false);
                        }
                        if (comando.equals("Limpiar"))
                                limpiar();

                }

        }

        class OyentoBotonOpcion implements ItemListener {

                @Override
                public void itemStateChanged(ItemEvent e) {

                        // Asigna los valores a los numeros racionales
                        numero1.asignarDatos(obtenerValor(JTFnum1.getText()), obtenerValor(JTFden1.getText()));
                        numero2.asignarDatos(obtenerValor(JTFnum2.getText()), obtenerValor(JTFden2.getText()));
                        // Poner el boton calcular
                        JBcalc.setEnabled(true);
                        if (e.getSource() == CHBsuma) {

                                op = " + ";
                                resultado.sumar(numero1, numero2);

                        } else if (e.getSource() == CHBresta) {
                                op = " - ";
                                resultado.restar(numero1, numero2);
                        } else if (e.getSource() == CHBmultiplicacion) {
                                op = " * ";
                                resultado.multiplicar(numero1, numero2);
                        } else if (e.getSource() == CHBdivision) {
                                op = " / ";
                                resultado.dividir(numero1, numero2);
                        }

                }
        }

        public static void main(String[] args) {
                Interfaz_Racional ventana = new Interfaz_Racional();
                ventana.setTitle("Operación Racional");
                ventana.setSize(800, 400);
                ventana.setVisible(true);
        }

}
