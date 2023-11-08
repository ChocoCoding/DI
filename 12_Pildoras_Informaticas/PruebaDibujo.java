
import java.awt.*;
import javax.swing.*;

public class PruebaDibujo {
   public static void main(String[] args) {
     MarcoConDibujos marcoConDibujos = new MarcoConDibujos();

     marcoConDibujos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     


   }

    

}


class MarcoConDibujos extends JFrame{

public MarcoConDibujos(){
    setTitle("Prueba con dibujo");
    setSize(400, 400);
    setVisible(true);
    setLocation(1000, 300);

    LaminaConFiguras lcf = new LaminaConFiguras();

    this.add(lcf);

}
}

class LaminaConFiguras extends JPanel{

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.drawRect(50, 50, 200, 200);

    }

}
