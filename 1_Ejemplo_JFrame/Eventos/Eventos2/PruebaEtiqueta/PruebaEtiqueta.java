
// Demostracionn de la clase JLabel. Con este código vamos a crear nuevas clasaes con 
// aspecto y nueva funcionalidad.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

class Boton extends JButton implements ActionListener {

    private Color color1 = Color.CYAN;
    private Color color2 = Color.yellow;
    private Color color3 = new Color(0x262d3d);

    public Boton() {
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        //Poner el boton a la escucha
        addActionListener(this);
    }

    public Boton(String texto) {
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setText(texto);
        //Poner el boton a la escucha
        addActionListener(this);
    }

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, 200, 200, 20, 20);

        g2.clip(r2d);
        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1,
                0.0f, 200, color2));
        g2.fillRect(0, 0, 200, 200);

        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(new GradientPaint(0.0f, 0.0f, color3,
                0.0f, 20, color3));
        g2.drawRoundRect(0, 0, 200, 180, 18, 18);
        g2.drawString("BOTON1", this.getWidth()/4, this.getHeight()/2);

    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Boton boton = (Boton) e.getSource();
        boton.setColor1(new Color(232,23,22));
    }

}



public class PruebaEtiqueta extends JFrame {

    
    private Boton boton1;

    public PruebaEtiqueta() {
        super("Prueba componentes con funcionalidad");
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        boton1 = new Boton();
        boton1.setPreferredSize(new Dimension(100, 100));
        

        contenedor.add(boton1);

    }

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        PruebaEtiqueta aplicacion = new PruebaEtiqueta();
        aplicacion.setSize(400, 400);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}