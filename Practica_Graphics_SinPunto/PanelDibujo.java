
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Color;

public class PanelDibujo extends JPanel {

    private Boolean limpiar;
    private int x;
    private int y;
    private int ancho;
    private int alto;

    public PanelDibujo() {
       
        this.limpiar = false;
       /// this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public PanelDibujo(Dimension size) {
        
        this.limpiar = false;   
        //this.setPreferredSize(new Dimension(size));
    }

    public PanelDibujo(int x, int y, int ancho, int alto) {
        super();
        this.x = x;
        this.y=y;
        this.ancho=ancho;
        this.alto=alto;
        this.limpiar = false;
        //this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void asignar(int x, int y, int ancho, int alto){
        this.x=x;
        this.y=y;
        this.ancho=ancho;
        this.alto=alto;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        return alto;
    }
    
    public void setLimpiar(Boolean limpiar) {
        this.limpiar = limpiar;
    }

    public boolean getLimpiar() {
        return this.limpiar;
    }


    public void paint(Graphics g){
        System.out.println("Entro aqui en el paint");
        super.paint(g);
    }
    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        System.out.println("Entra aqui en el paintComponent");

        String figura = "RECTANGULO-CUADRADO";
        g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 22));
        
       
        if (this.limpiar) {
            
            g.setColor(this.getBackground());
            g.fillRect(x,y,ancho,alto);
        } else {
            g.setColor(Color.RED);
            g.drawString(figura, (figura.length() + this.getWidth() / 4), 40);
            g.setColor(Color.yellow);
            g.drawRect(x,y,alto,ancho);
            g.setColor(Color.blue);
            g.fillRect((x + 2),(y + 2), alto - 2, ancho - 2);
        }

    }
}
