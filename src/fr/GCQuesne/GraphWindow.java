package fr.GCQuesne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static fr.GCQuesne.MainWindow.myAccount;
import static fr.GCQuesne.MainWindow.statAccountTab;

public class GraphWindow extends JFrame {
  private final DrawPanel drawPanel = new DrawPanel();


  public GraphWindow() {
    setTitle("- Statistique du compte : " + myAccount.getAccountNumber());
    setSize(400, 570);
    setLocation(1500, 400);
    setBackground(Color.WHITE);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    getContentPane().add(drawPanel);

  }

  public class DrawPanel extends JPanel {

    int originGraphY = 420;
    int totalHeight = 350;

    int rentHeight = calculateRateHeight(statAccountTab[5]);
    int foodHeight = calculateRateHeight(statAccountTab[6]);
    int miscHeight = calculateRateHeight(statAccountTab[7]);

    int miscPositionY = originGraphY - miscHeight;
    int foodPositionY = originGraphY - miscHeight - foodHeight;
    int rentPositionY = originGraphY - miscHeight - foodHeight - rentHeight;

    public void paintComponent(Graphics graphics) {
      super.paintComponents(graphics);

      graphics.drawString("Numéro de compte " + myAccount.getAccountNumber()
          , 140, 30);
      graphics.drawString("Crédit = " + statAccountTab[0] + "€", 50, 450);
      graphics.drawString("Débit = " + statAccountTab[1] + "€", 180, 450);
      if (statAccountTab[0] != 0) {
        //Graph credit
        graphics.setColor(Color.CYAN);
        graphics.fillRect(60, originGraphY - totalHeight, 60, 350);
      }
      if (statAccountTab[2] != 0) {
        //Graph rent
        graphics.setColor(Color.RED);
        graphics.drawString("Loyer", 300, rentPositionY);
        graphics.fillRect(185, rentPositionY, 60, rentHeight);
      }
      if (statAccountTab[3] != 0) {
        //Graph food
        graphics.setColor(Color.ORANGE);
        graphics.drawString("Alimentation", 300, foodPositionY);
        graphics.fillRect(185, foodPositionY, 60, foodHeight);
      }
      if (statAccountTab[4] != 0) {
        //Graph misc
        graphics.setColor(Color.MAGENTA);
        graphics.drawString("Divers", 300, miscPositionY);
        graphics.fillRect(185, miscPositionY, 60, miscHeight);
      }

    }

    private int calculateRateHeight(double percentageOfType) {
      return (int) (percentageOfType * totalHeight / 100);
    }

  }

}

