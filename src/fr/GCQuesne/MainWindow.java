package fr.GCQuesne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static fr.GCQuesne.Project.myListAccount;

public class MainWindow extends JFrame implements ActionListener {
  static Account myAccount;
  static double[] statAccountTab = new double[5];
  TextField response;
  Label errorMessage;
  JPanel entryPanel = new JPanel();
  JPanel errorPanel = new JPanel(new FlowLayout());

  public MainWindow() {
    setTitle("- Statistique d'un compte -");
    setSize(500, 190);
    setLocation(1400, 300);
    setBackground(Color.white);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    add(entryPanel, BorderLayout.CENTER);
    add(errorPanel, BorderLayout.SOUTH);

    response = new TextField(10);
    response.addActionListener(this);

    entryPanel.add(new Label("Numéro de compte : "), BorderLayout.WEST);
    entryPanel.add(response, BorderLayout.CENTER);

    errorPanel.add(errorMessage = new Label(), new FlowLayout());
    errorMessage.setSize(190, 100);
    errorMessage.setBackground(Color.RED);
    errorMessage.setVisible(false);
  }

  public void actionPerformed(ActionEvent event) {

    System.out.println("la valeur saisi dans le champ : " + response.getText());
    if (myListAccount.listAccount.containsKey(response.getText())) {
      myAccount = myListAccount.selectAccount(response.getText());
      statAccountTab = myAccount.sumTransactions(myAccount);

      errorMessage.setVisible(false);
      GraphWindow statWindow = new GraphWindow();
      statWindow.setVisible(true);
    } else {
      errorMessage.setText("Compte inconnu");
      errorMessage.setVisible(true);
    }
  }

}
