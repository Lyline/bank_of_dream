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
  protected double accountValue, accountInitialValue;
  protected int lineRecorded;
  private String clientFirstName;
  private String accountType;
  private String clientLastName;
  private String accountNumber;
  BookEntry line;

  public Account(char accountSavingType) {
    Scanner sc = new Scanner(System.in);
    if (accountSavingType == 'E') {
      accountType = "Épargne";

      System.out.println("Saisir le nom du client :");
      clientLastName = sc.next();
      System.out.println("Saisir le prénom du client :");
      clientFirstName = sc.next();
      System.out.println("Saisir le numéro du nouveau compte :");
      accountNumber = sc.next();
      accountInitialValue = checkAccountInitialValue();
      lineRecorded = 0;
    }
  }

  public String getClientFirstName() {
    return clientFirstName;
  }

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

  public Account() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Saisir le nom du client :");
    clientLastName = sc.next();
    System.out.println("Saisir le prénom du client :");
    clientFirstName = sc.next();
    System.out.println("Saisir le numéro du nouveau compte :");
    accountNumber = sc.next();
    accountType = checkingAccountType();
    accountInitialValue = checkAccountInitialValue();
    lineRecorded = 0;
  }

  public String getClientLastName() {
    return clientLastName;
  }

  public Account(String accountNumberEmpty) {
    accountNumber = accountNumberEmpty;
    lineRecorded = 0;
  }

  public void printAccount() {
    System.out.println("Nom du client : " + clientLastName + "\nPrénom du client : " + clientFirstName);
    System.out.print("Le compte n° : " + accountNumber + " est un compte " + accountType);

    if (lineRecorded > 0) {
      line.printAccountingRecord();
      System.out.print("\nValeur du compte : " + accountValue + " €\n");
    } else
      System.out.println("\nValeur initiale : " + accountInitialValue + " €\n\n-- Aucune ligne comptable enregistrée --");
  }

  public void createRecord() {
    line = new BookEntry();
    accountValue = accountInitialValue + line.getTransactionValue();
    lineRecorded = 1;
  }

  private String checkingAccountType() {
    Scanner sc = new Scanner(System.in);
    char tempIn;
    String tempOut = "";

    do {
      System.out.println("Saisir le type du nouveau compte [(C)ourant, (J)oint] :");
      tempIn = sc.next().toUpperCase().charAt(0);
    } while (tempIn != 'C' && tempIn != 'J');
    switch (tempIn) {
      case 'C':
        tempOut = "Courant";
        break;
      case 'J':
        tempOut = "Joint";
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
