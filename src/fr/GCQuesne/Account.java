package fr.GCQuesne;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class Account merge all functionalities Account's object
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Account {
  String clientFirstName, accountType, clientLastName, accountNumber;
  double accountValue, accountSavingRate;

  public void createAccount() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Saisir le nom du client :");
    clientLastName = sc.next();
    System.out.println("Saisir le prénom du client :");
    clientFirstName = sc.next();
    System.out.println("Saisir le numéro du nouveau compte :");
    accountNumber = sc.next();
    System.out.println("Saisir le type du nouveau compte [Courant, Joint ou Épargne] :");
    accountType = sc.next();
    if (accountType.equals("e") || accountType.equals("é") || accountType.equals("E")) {
      System.out.println("Taux de placement :");
      accountSavingRate = sc.useLocale(Locale.US).nextDouble();
    }
    System.out.println("Saisir la valeur initiale :");
    accountValue = sc.useLocale(Locale.US).nextDouble();
  }

  public void printAccount() {
    System.out.println("Nom du client : " + clientLastName + "\nPrénom du client : " + clientFirstName);
    System.out.print("\nLe compte n° : " + accountNumber + " est un compte ");
    if (accountType.equals("C") || accountType.equals("c")) System.out.println("courant");
    else if (accountType.equals("J") || accountType.equals("j")) System.out.println("joint");
    else if (accountType.equals("e") || accountType.equals("é") || accountType.equals("E")) {
      System.out.println("épargne dont le taux est de " + accountSavingRate + " %\n");
    }
    System.out.println("Valeur initiale : " + accountValue + " €");
  }

}
