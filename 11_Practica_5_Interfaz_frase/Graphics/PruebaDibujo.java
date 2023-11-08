package Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoConDibujos marco = new MarcoConDibujos();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

    class MarcoConDibujos extends JFrame{
        
        public MarcoConDibujos(){
            setTitle("Prueba con dibujo");
            setSize(400,400);

            LaminaConFiguras laminaConFiguras = new LaminaConFiguras();
            
            this.add(laminaConFiguras);
        }
    }

    class LaminaConFiguras extends JPanel{
        public void paintComponent(Graphics g){
            
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            Rectangle2D rectangle2d = new Rectangle2D.Double(100,100,200,150);
            g2.setPaint(Color.BLUE);
            g2.draw(rectangle2d);
            g2.setPaint(Color.RED);
            g2.fill(rectangle2d);
            
        }

    }