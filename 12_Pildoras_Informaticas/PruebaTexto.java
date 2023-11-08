import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PruebaTexto {


    public static void main(String[] args) {
        MarcoTexto marcoTexto = new MarcoTexto();
        marcoTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}


class MarcoTexto extends JFrame{
    public MarcoTexto(){

        setBounds(600, 300, 600, 350);

        LaminaTexto laminaTexto = new LaminaTexto();

        add(laminaTexto);

        setVisible(true);
        
    }



}

class LaminaTexto extends JPanel{

    private JTextField campo1;
    private JLabel texto1;
    private JLabel resultado;
    public LaminaTexto(){
        setLayout(new BorderLayout());

        JPanel miLamina2 = new JPanel();
        miLamina2.setLayout(new FlowLayout());


        campo1 = new JTextField(20);
        texto1 = new JLabel("Introduce tu email");
        resultado = new JLabel("",JLabel.CENTER);



        miLamina2.add(texto1);
        miLamina2.add(campo1);
        add(resultado,BorderLayout.CENTER);


        //Creamos el boton
        JButton miBoton = new JButton("Comprobar email");
        //Instanciamos la clase del evento
        DameTexto miEvento = new DameTexto();
        //Ponemos el boton a la escucha
        miBoton.addActionListener(miEvento);
        //Añadimos el boton
        miLamina2.add(miBoton);

        add(miLamina2,BorderLayout.NORTH);
    }

    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int correcto = 0;
            String email = campo1.getText().trim();
            for(int i = 0; i< email.length(); i++){
                if(email.charAt(i) == '@'){
                    correcto++;
                }
            }
            if(correcto != 1){
                    System.out.println("Email Incorrecto");
                    resultado.setText("Email Incorrecto");
                }else {
                    System.out.println("Correcto");
                    resultado.setText("Email Correcto");
                }
            System.out.println(campo1.getText().trim());

        }

        

    }

}
