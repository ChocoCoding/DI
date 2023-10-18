import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class interfaz_tabla_multiplicar extends JFrame  {

     Boton[] BotonsNumero1 = new Boton[10];
     Boton[] BotonsNumero2 = new Boton[10];
     Boton[] BotonsOperacion = new Boton[10];

     JLabel num1 = new JLabel();
     JLabel num2 = new JLabel();
     JLabel resul = new JLabel();

     JTextField numero1 = new JTextField();
     JTextField numero2 = new JTextField();
     JTextField resultado = new JTextField();
     Boton calc = new Boton("SUMAR");

     JLabel etiqueta = new JLabel();

     JComboBox listanumeros = new JComboBox();

     Panel np = new Panel();
     Panel cp = new Panel();
     Panel sp = new Panel();

     private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
               double weightx,
               double weighty, int fill, int anchor, Insets insets) {
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

     private void initComponents() {
          // Botones de númmeros
          for (int i = 0; i < BotonsNumero1.length; i++) {
               BotonsNumero1[i] = new Boton(String.valueOf(i));
               BotonsNumero1[i].setEnabled(false);

               BotonsOperacion[i] = new Boton("=");
               BotonsOperacion[i].setEnabled(false);
               BotonsNumero2[i] = new Boton();
               BotonsNumero2[i].setEnabled(false);
          }

          for (int j = 0; j < BotonsNumero1.length; j++) {

               cp.add(BotonsNumero1[j], createConstraints(0, j, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
               cp.add(BotonsOperacion[j], createConstraints(1, j, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
               cp.add(BotonsNumero2[j], createConstraints(2, j, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
          }

         
     }

     interfaz_tabla_multiplicar() {

          cp.setLayout(new GridBagLayout());
          initComponents();
          this.add(cp, BorderLayout.CENTER);

          np.setLayout(new GridLayout(2, 1));
          etiqueta.setFont(new Font("Arial", Font.BOLD, 28));

          etiqueta.setText("Tabla de Multiplicar");
          // Alinear la etiqueta en el centro de la ventana
          etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

          np.add(etiqueta);
          np.add(listanumeros);

          for (int i = 1; i < 10; i++) {
               listanumeros.addItem(String.valueOf(i));

               this.add(np, BorderLayout.NORTH);

               num1.setFont(new Font("Arial", Font.BOLD, 14));
               num2.setFont(new Font("Arial", Font.BOLD, 14));
               resul.setFont(new Font("Arial", Font.BOLD, 14));

               num1.setText("Numero1:");
               num2.setText("Numero2:");
               resul.setText("Resultado");
               num1.setAlignmentX(JLabel.CENTER);
               num2.setAlignmentX(JLabel.CENTER);
               resul.setAlignmentX(JLabel.CENTER);

               resul.setEnabled(false);

               sp.setLayout(new GridBagLayout());

               sp.add(num1, createConstraints(0, 0, 1, 1, 0.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 10, 10, 4)));
               sp.add(numero1, createConstraints(1, 0, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
               sp.add(num2, createConstraints(0, 1, 1, 1, 0.0, 0.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 10, 10, 4)));
               sp.add(numero2, createConstraints(1, 1, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
               sp.add(resul, createConstraints(0, 2, 1, 1, 0.0, 0.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 10, 10, 4)));
               sp.add(resultado, createConstraints(1, 2, 1, 1, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
               sp.add(calc, createConstraints(3, 0, 2, 3, 1.0, 1.0,
                         GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

               this.add(sp, BorderLayout.SOUTH);
              

          }

     }

  

     public static void main(String[] args) {
          // TODO code application logic here
          interfaz_tabla_multiplicar multiplicar = new interfaz_tabla_multiplicar();

          multiplicar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          multiplicar.setSize(350, 600);
          multiplicar.setVisible(true);
     }

     
}
