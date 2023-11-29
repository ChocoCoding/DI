import java.awt.*;
import javax.swing.*;

public class VentanaLogin extends JFrame{
    
    Container c ;
    
    //JTextField
    JTextField txtUsu, txtContra;

    //JLabel
    JLabel labelUsu, labelContra;

    //Botones
    JButton btnAceptar,btnCancelar;

    //Paneles
    JPanel panelCentral;

    public VentanaLogin(){
        c = getContentPane();
        c.setLayout(new GridBagLayout());
        
        //Parte Central
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(2,2));
        labelUsu = new JLabel("Usuario");
        txtUsu = new JTextField();
        labelContra = new JLabel("Contraseña");
        txtContra = new JTextField();
        panelCentral.add(labelUsu);
        panelCentral.add(txtUsu);
        panelCentral.add(labelContra);
        panelCentral.add(txtContra);


        c.add(panelCentral, crearRestricciones(0, 1, 2, 1, 1.0, 1.0,
        GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, 0, 0, new Insets(0,0,0,0)));

        //Panel inferior
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        c.add(btnAceptar, crearRestricciones(0, 2, 1, 1, 1.0, 0.5,
        GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, 0, 0, new Insets(0,0,0,0)));
        c.add(btnCancelar, crearRestricciones(1, 2, 1, 1, 1.0, 0.5,
        GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, 0, 0, new Insets(0,0,0,0)));
    }


    public GridBagConstraints crearRestricciones(
        int gridx,
        int gridy,
        int gridwidth,
        int gridheight,
        double weightx,
        double weighty,
        int fill,
        int anchor,
        int ipadx,
        int ipady,
        Insets insets) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = gridx;
                constraints.gridy = gridy;
                constraints.gridwidth = gridwidth;
                constraints.gridheight = gridheight;
                constraints.weightx = weightx;
                constraints.weighty = weighty;
                constraints.ipadx = ipadx;
                constraints.ipady = ipady;
                constraints.fill = fill;
                constraints.anchor = anchor;
                constraints.insets = insets;
                return constraints;
    }
    
}
