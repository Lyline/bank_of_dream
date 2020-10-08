package fr.GCQuesne;

import javax.swing.*;
import java.io.Serializable;

/**
 * Main file of application
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Project extends JFrame implements Serializable {
  static ListAccount myListAccount;
  static FileAccount myFileAccount;

  public static void main(String[] args) {
    myListAccount = new ListAccount();
    myFileAccount = new FileAccount();

    if (myFileAccount.openFile("read")) {
      myListAccount = myFileAccount.readFile();
      myFileAccount.closeFile();
    }
    JFrame frame = new JFrame("- Gestionnaire de comptes -");
    frame.setContentPane(new IndexAppliGUI().mainPanel);
    frame.setLocation(1400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
