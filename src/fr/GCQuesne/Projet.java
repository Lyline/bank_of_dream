package fr.GCQuesne;

import java.util.Locale;
import java.util.Scanner;

/**
 * Main file of application
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Projet {
  static long accountNumber;
  static char accountType, paymentTheme, paymentType;
  static double accountValue, accountSavingRate, date;
  static int selectionMenu;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    do {
      selectionMenu = mainMenu();

      switch (selectionMenu) {
        case 1:
          System.out.println("Type du compte [Type possible : courant, joint, épargne] :");
          accountType = sc.next().charAt(0);
          System.out.println("Numéro de compte :");
          accountNumber = sc.nextLong();
          System.out.println("Première valeur créditée :");
          accountValue = sc.useLocale(Locale.US).nextDouble();
          if (accountType == 'e' || accountType == 'é' || accountType == 'E') {
            System.out.println("Taux de placement :");
            accountSavingRate = sc.useLocale(Locale.US).nextDouble();
          }
          break;

        case 2:
          System.out.println("Saisir le numéro de compte :");
          long accountNumberCheck = sc.nextLong();
          if (accountNumberCheck == accountNumber) printAccount();
          else System.out.println("Numéro de compte non valide");
          break;
        case 3:
          System.out.println("Option non programmée");
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

  public static void printAccount() {
    System.out.print("Le compte n° : " + accountNumber + " est un compte ");
    if (accountType == 'C' || accountType == 'c') System.out.println("Courant");
    else if (accountType == 'J' || accountType == 'j') System.out.println("Joint");
    else if (accountType == 'E' || accountType == 'e' || accountType == 'é') {
      System.out.println("épargne dont le taux est de " + accountSavingRate + " %\n");
    }
    System.out.println("Valeur initiale : " + accountValue + " €");

  }
}


