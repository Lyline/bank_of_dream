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

  /**
   * Constructor, creates a new account's object
   * <ul>
   *   <li>The last name of this client</li>
   *   <li>The first name of this client</li>
   *   <li>The number</li>
   *   <li>The type (Current, Join or Saving)</li>
   *   <li>The initial value (always positive)</li>
   *   <li>The number of accounting entry equals at 0</li>
   * </ul>
   *
   * @since 1.0
   */
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

  /**
   * Constructor, creates a new saving account's object
   * <ul>
   *  <li>The last name of this client</li>
   *  <li>The first name of this client</li>
   *  <li>The number</li>
   *  <li>The type : Saving</li>
   *  <li>The initial value, always positive</li>
   *  <li>The number of accounting entry equals at 0</li>
   * </ul>
   *
   * @param accountSavingType the type of this account must be equals at 'E'
   * @see SavingAccount
   * @since 1.0
   */
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

  /**
   * Constructor, initializes a new account without number
   *
   * @param accountNumberEmpty the number of this account is empty
   * @since 1.0
   */
  public Account(String accountNumberEmpty) {
    accountNumber = accountNumberEmpty;
    lineRecorded = 0;
  }

  /**
   * Gets the first name of this client
   *
   * @return current first name of this client
   * @since 1.0
   */
  public String getClientFirstName() {
    return clientFirstName;
  }

  /**
   * Gets the last name of this client
   *
   * @return current last name of this client
   * @since 1.0
   */
  public String getClientLastName() {
    return clientLastName;
  }

  /**
   * Gets the type of this account (Current, Join or Saving)
   *
   * @return current type of this account
   * @since 1.0
   */
  public String getAccountType() {
    return accountType;
  }

  /**
   * Sets the type of this account (Current, Join or Saving)
   *
   * @param accountType sets the new type of this account
   * @since 1.0
   */
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  /**
   * Gets the number of this account
   *
   * @return current number of this account
   * @since 1.0
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * Sets the number of this account - Warning, it's to delete !!!
   *
   * @param accountNumber
   * @since 1.0
   */
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * Gets the value of this account
   *
   * @return current value of this account
   * @since 1.0
   */
  public double getAccountValue() {
    return accountValue;
  }

  /**
   * Sets the value of this account
   *
   * @param accountValue the new value of this account
   * @since 1.0
   */
  public void setAccountValue(double accountValue) {
    this.accountValue = accountValue;
  }

  /**
   * Prints the data of this account
   * <ul>
   *   <li>The last name of this client</li>
   *   <li>The first name of this client</li>
   *   <li>The number of this account</li>
   *   <li>The type (Current, Join or Saving)</li>
   *   <li>The value</li>
   *   <li>The last accounting record or a message "no accounting record"</li>
   * </ul>
   *
   * @since 1.0
   */
  public void printAccount() {
    System.out.println("Nom du client : " + clientLastName + "\nPrénom du client : " + clientFirstName);
    System.out.print("Le compte n° : " + accountNumber + " est un compte " + accountType);

    if (lineRecorded > 0) {
      line.printAccountingRecord();
      System.out.print("\nValeur du compte : " + accountValue + " €\n");
    } else
      System.out.println("\nValeur initiale : " + accountInitialValue + " €\n\n-- Aucune ligne comptable enregistrée --");
  }

  /**
   * Creates a accounting record with a book entry's object, sets the new value of this account after this transaction and sets the line recorded's variable at 1
   *
   * @since 1.0
   */
  public void createRecord() {
    line = new BookEntry();
    accountValue = accountInitialValue + line.getTransactionValue();
    lineRecorded = 1;
  }

  /**
   * Checks and sets the type of this account
   *
   * @return valid type (Current or Join)
   * @since 1.0
   */
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

  /**
   * Checks and sets the initial value of this account who must be positive, prints warning message if this value is negative
   *
   * @return valid initial value (positive)
   * @since 1.0
   */
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
