package fr.GCQuesne;

import java.io.*;

/**
 * Class FileAccount merge all functions of creation, read and write data's file
 *
 * @author GCQuesne
 * @since 1.0
 */

public class FileAccount {
  private final String nameFile = "account.dat";
  private ObjectInputStream ofR;
  private ObjectOutputStream ofW;
  private char mode;

  /**
   * Opens this file on reading or writing
   *
   * @param s this type of the mode selected : R (Read) or W (Write)
   * @since 1.0
   */
  public boolean openFile(String s) {
    try {
      mode = (s.toUpperCase()).charAt(0);

      if (mode == 'R') {
        ofR = new ObjectInputStream(new FileInputStream(nameFile));
        System.out.println("-- Fichier trouvé --");
      } else if (mode == 'W') {
        ofW = new ObjectOutputStream(new FileOutputStream(nameFile));
        System.out.println("-- Fichier créé --");
      }
      return true;
    } catch (IOException e) {
      System.out.println("-- Aucun fichier trouvé --");
      return false;
    }
  }

  /**
   * Writes the data on this file
   *
   * @param temp this current account to write on the file
   * @since 1.0
   */
  public void writeFile(ListAccount temp) {
    try {
      if (temp != null) {
        ofW.writeObject(temp);
        System.out.println("-- Données enregistrées --");
      }
    } catch (IOException e) {
      System.out.println("-- Impossible d'enregistrer les données --");
    }
  }

  /**
   * Reads the data's account on this file
   *
   * @return this account object
   * @since 1.0
   */
  public ListAccount readFile() {
    try {
      ListAccount temp = (ListAccount) ofR.readObject();
      return temp;
    } catch (IOException e) {
      System.out.println(nameFile + " : Erreur de lecture");
    } catch (ClassNotFoundException e) {
      System.out.println(nameFile + " n'est pas du bon format");
    }
    return null;
  }

  /**
   * Closes the data file
   *
   * @since 1.0
   */
  public void closeFile() {
    try {
      if (mode == 'R') ofR.close();
      else if (mode == 'W') ofW.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}