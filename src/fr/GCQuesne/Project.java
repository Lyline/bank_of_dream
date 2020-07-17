package fr.GCQuesne;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Main file of application
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Project implements Serializable {
  static int selectionMenu;

  public static void main(String[] args) {
    ListAccount myListAccount = new ListAccount();

    FileAccount myFileAccount = new FileAccount();
    if (myFileAccount.openFile("read")) {
      myListAccount = myFileAccount.readFile();
      myFileAccount.closeFile();
    }

    do {
      selectionMenu = mainMenu();
      switch (selectionMenu) {
        case 1:
          myListAccount.addAccount();
          break;

        case 2:
          myListAccount.addAccountingRecord();
          break;

        case 3:
          String accountPrinted = myListAccount.searchAccount();
          myListAccount.printAccount(accountPrinted);
          break;
        case 4:
          myListAccount.deleteAccount();
          break;

        case 5:
          myListAccount.printAllAccounts();
          break;

        case 6:
          myFileAccount.openFile("write");
          myFileAccount.writeFile(myListAccount);
          myFileAccount.closeFile();
          exitApplication();
          break;

        case 7:
          helpApplication();
          break;
        default:
          System.out.println("Sélection non reconnue\n");
      }
    } while (selectionMenu != 6);
  }

  /**
   * Prints the main menu and selects the item:
   * <ul>
   *   <li>Create an account</li>
   *   <li>Print an account</li>
   *   <li>Create an accounting record</li>
   *   <li>Exit to the application</li>
   *   <li>Print the help of main menu</li>
   * </ul>
   *
   * @return the value of this selected item
   */
  public static int mainMenu() {
    int selectMenu;
    Scanner sc = new Scanner(System.in);

    System.out.println("\n1 Créer un compte\n" +
        "2 Ajouter une ligne comptable\n" +
        "3 Rechercher un compte\n" +
        "4 Supprimer un compte\n" +
        "5 Afficher la liste de tous les comptes\n" +
        "6 Sortir\n" +
        "7 De l'aide\n\n" +
        "Votre choix :");
    selectMenu = sc.nextInt();
    return selectMenu;
  }

  /**
   * Exits to the application
   */
  public static void exitApplication() {
    System.out.println("À Bientôt");
    System.exit(0);
  }

  /**
   * Prints the help of main menu
   */
  public static void helpApplication() {
    System.out.println("Créer un compte : Ouverture d'un nouveau compte\n" +
        "Afficher un compte : Consultation d'un compte existant\n" +
        "Créer une ligne comptable : Ajout d'un mouvement bancaire sur un compte\n" +
        "Sortir : Fermeture l'application\n" +
        "De l'aide : Affichage d'un menu d'aide\n");
  }

}
