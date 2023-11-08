import java.awt.Frame;

import javax.swing.JFrame;

public class marco {

    public static void main(String[] args) {
        miMarco marco = new miMarco();

        marco.setVisible(true);

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setSize(600, 600);

        marco.setLocation(1000, 300);

    }

   

}
    class miMarco extends JFrame{
      
        
    }