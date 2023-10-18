import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCardLayout extends JFrame {
  JPanel buttonPanel;
  JButton nextButton, previousButton;

  VentanaCardLayout() {
    super("CardLayout");
    buttonPanel = new JPanel();
    
    previousButton = new JButton("Previous");
    buttonPanel.add(previousButton);
    nextButton = new JButton("Next");
    buttonPanel.add(nextButton);
    
    add(buttonPanel, BorderLayout.SOUTH);

  }

  public static void main(String[] args) {

    VentanaCardLayout miVentanaCard = new VentanaCardLayout();
    // Crear un nuevo panel
    JPanel cardPanel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    // Asigno un nuevo layout al panel
    cardPanel.setLayout(cardLayout);

    for (int i = 1; i <= 5; i++) {
      JButton card = new JButton("Tarjeta " + i);
      card.setPreferredSize(new Dimension(200, 200));
      String cardName = "card" + 1;
      // Añade al panel los 5 botones, cada uno con un nombre distinto
      cardPanel.add(card, cardName);
    }
    miVentanaCard.add(cardPanel, BorderLayout.CENTER);
    // Poner a la escucha los botones para dar funcionalidad y realizar la acción 
    // mediante una función lambda
    miVentanaCard.nextButton.addActionListener(evt -> cardLayout.next(cardPanel));
    miVentanaCard.previousButton.addActionListener(evt -> cardLayout.previous(cardPanel));
    // método pack(), se ocupa del tamaño y la posición de los componentes
    miVentanaCard.pack();
    miVentanaCard.setVisible(true);
  }
}