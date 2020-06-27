package fr.GCQuesne;

import java.util.Scanner;

/**
 * Main file of application
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Project {
  static int selectionMenu;

  public static void main(String[] args) {
    String accountNumberCheck;
    String emptyValue = "";
    
    Account myAccount = new Account(emptyValue);
    Scanner sc = new Scanner(System.in);

    do {
      selectionMenu = mainMenu();

      switch (selectionMenu) {
        case 1:
          myAccount = new Account();
          break;

        case 2:
          System.out.println("Saisir le numéro de compte :");
          accountNumberCheck = sc.next();
          if (accountNumberCheck.equals(myAccount.getAccountNumber())) myAccount.printAccount();
          else System.out.println("Numéro de compte non valide");
          break;

        case 3:
          System.out.println("Saisir le numéro de compte :");
          accountNumberCheck = sc.next();
          if (accountNumberCheck.equals(myAccount.getAccountNumber())) myAccount.createRecord();
          else System.out.println("Numéro de compte non valide");
          break;
        case 4:
          exitApplication();
          break;
        case 5:
          helpApplication();
          break;
        default:
          System.out.println("Sélection non reconnue\n");
      }
    } while (selectionMenu != 4);
  }

  public static int mainMenu() {
    int selectMenu;
    Scanner sc = new Scanner(System.in);

    System.out.println("\n1 Créer un compte\n" +
        "2 Afficher un compte\n" +
        "3 Crée une ligne comptabe\n" +
        "4 Sortir\n" +
        "5 De l'aide\n\n" +
        "Votre choix :");
    selectMenu = sc.nextInt();
    return selectMenu;
  }

  public static void exitApplication() {
    System.out.println("À Bientôt");
    System.exit(0);
  }

  public static void helpApplication() {
    System.out.println("Créer un compte : Ouverture d'un nouveau compte\n" +
        "Afficher un compte : Consultation d'un compte existant\n" +
        "Créer une ligne comptable : Ajout d'un mouvement bancaire sur un compte\n" +
        "Sortir : Fermeture l'application\n" +
        "De l'aide : Affichage d'un menu d'aide\n");
  }

}


