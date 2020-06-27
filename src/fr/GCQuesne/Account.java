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
  private String clientFirstName, accountType, clientLastName, accountNumber;
  private double accountValue, accountInitialValue, accountSavingRate;
  private int lineRecorded;

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getAccountValue() {
    return accountValue;
  }

  public void setAccountValue(double accountValue) {
    this.accountValue = accountValue;
  }

  public double getAccountSavingRate() {
    return accountSavingRate;
  }

  public void setAccountSavingRate(double accountSavingRate) {
    this.accountSavingRate = accountSavingRate;
  }

  BookEntry line;

  public void createAccount() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Saisir le nom du client :");
    clientLastName = sc.next();
    System.out.println("Saisir le prénom du client :");
    clientFirstName = sc.next();
    System.out.println("Saisir le numéro du nouveau compte :");
    accountNumber = sc.next();
    accountType = checkingAccountType();
    if (accountType.equals("Épargne")) {
      System.out.println("Taux de placement :");
      accountSavingRate = sc.useLocale(Locale.US).nextDouble();
    }
    accountInitialValue = checkAccountInitialValue();
    lineRecorded = 0;
  }

  public void printAccount() {
    System.out.println("Nom du client : " + clientLastName + "\nPrénom du client : " + clientFirstName);
    System.out.print("Le compte n° : " + accountNumber + " est un compte " + accountType);

    if (accountType.equals("Épargne")) System.out.print(" dont le taux est de " + accountSavingRate + " %");
    System.out.print("\nValeur initiale : " + accountInitialValue + " €\n");

    if (lineRecorded > 0) {
      line.printAccountingRecord();
      System.out.print("\nValeur du compte : " + accountValue + " €\n");
    } else System.out.println("\n\n-- Aucune ligne comptable enregistrée --");
  }

  public void createRecord() {
    line = new BookEntry();

    line.createAccountingRecord();
    lineRecorded = 1;
    accountValue = accountInitialValue + line.getTransactionValue();
  }

  private String checkingAccountType() {
    Scanner sc = new Scanner(System.in);
    char tempIn;
    String tempOut = "";

    do {
      System.out.println("Saisir le type du nouveau compte [(C)ourant, (J)oint ou (E)pargne] :");
      tempIn = sc.next().toUpperCase().charAt(0);
    } while (tempIn != 'C' && tempIn != 'J' && tempIn != 'E');
    switch (tempIn) {
      case 'C':
        tempOut = "Courant";
        break;
      case 'J':
        tempOut = "Joint";
        break;
      case 'E':
        tempOut = "Épargne";
        break;
    }
    return tempOut;
  }

  private double checkAccountInitialValue() {
    double temp;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("Saisir la valeur initiale :");
      temp = sc.useLocale(Locale.US).nextDouble();
      if (temp < 0) System.out.println("-- Attention, saisir une valeur positive --");
    } while (temp < 0);
    return temp;
  }
}
