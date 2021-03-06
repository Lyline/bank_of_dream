package fr.GCQuesne;

import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

import static fr.GCQuesne.Statistic.percentage;
import static java.lang.Double.parseDouble;

/**
 * Class Account merge all functionalities Account's object
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Account implements Serializable {
  protected double accountValue, accountInitialValue;
  private String clientFirstName;
  private String accountType;
  private String clientLastName;
  private String accountNumber;
  public static final int numberRecordMaxi = 10;
  protected BookEntry[] line;
  protected int lineRecorded;


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
    line = new BookEntry[numberRecordMaxi];

    System.out.println("Saisir le nom du client :");
    clientLastName = sc.next();
    System.out.println("Saisir le prénom du client :");
    clientFirstName = sc.next();
    System.out.println("Saisir le numéro du nouveau compte :");
    accountNumber = sc.next();
    accountType = checkingAccountType();
    accountValue = checkAccountInitialValue();
    lineRecorded = -1;
  }

  public Account(String clientLastName, String clientFirstName,
                 String accountType, String accountNumber, String accountInitialValue) {
    line = new BookEntry[numberRecordMaxi];
    lineRecorded = -1;

    Double accountInitialValueTemp = parseDouble(accountInitialValue);
    this.accountValue = accountInitialValueTemp;
    this.clientFirstName = clientFirstName;
    this.accountType = accountType;
    this.clientLastName = clientLastName;
    this.accountNumber = accountNumber;
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
      line = new BookEntry[numberRecordMaxi];
      accountType = "Épargne";

      System.out.println("Saisir le nom du client :");
      clientLastName = sc.next();
      System.out.println("Saisir le prénom du client :");
      clientFirstName = sc.next();
      System.out.println("Saisir le numéro du nouveau compte :");
      accountNumber = sc.next();
      accountValue = checkAccountInitialValue();
      lineRecorded = -1;
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
    System.out.println("\nNom du client : " + clientLastName + "\nPrénom du client : " + clientFirstName);
    System.out.print("Le compte n° : " + accountNumber + " est un compte " + accountType);

    if (lineRecorded >= 0) {
      for (int i = 0; i <= lineRecorded; i++) {
        line[i].printAccountingRecord();
      }
      System.out.print("\nValeur du compte : " + accountValue + " €\n\n");
    } else
      System.out.print("\nValeur initiale : " + accountValue + " €" +
          "\n-- Aucune ligne comptable enregistrée --\n\n");
  }

  /**
   * Creates a accounting record with a book entry's array object, sets the new value of this account after this transaction and sets the line recorded's variable increment 1 until 9 (an array of 10 elements)
   *
   * @since 1.0
   */
  public void createRecord() {
    lineRecorded++;
    accountInitialValue = accountValue;

    if (lineRecorded >= numberRecordMaxi) {
      lineRecorded--;
      shiftLine();
    }
    line[lineRecorded] = new BookEntry();
    accountValue = accountInitialValue + line[lineRecorded].getTransactionValue();

  }

  /**
   * Shift this accounting records if the array's elements are greater than 10
   */
  private void shiftLine() {
    for (int i = 1; i < numberRecordMaxi; i++) {
      line[i - 1] = line[i];
    }
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

  /**
   * Sum all credits and debits, dispatch the debits by type of theme
   *
   * @return array of sums [credit, debit, rent, food, miscellaneous]
   */
  public double[] sumTransactions(Account myAccount) {
    String typeTransaction;
    int lineAccountingRecord = 0;
    double credit = 0, debit = 0, valueTransaction,
        sumRent = 0, sumFood = 0, sumMisc = 0;

    double[] sum = new double[8];

    do {
      valueTransaction = myAccount.line[lineAccountingRecord].getTransactionValue();
      typeTransaction = myAccount.line[lineAccountingRecord].getTransactionTheme();

      if (valueTransaction > 0) credit += valueTransaction;
      if (valueTransaction < 0) {
        debit += Math.abs(valueTransaction);
        switch (typeTransaction) {
          case "Loyer":
            sumRent += Math.abs(valueTransaction);
            break;
          case "Alimentation":
            sumFood += Math.abs(valueTransaction);
            break;
          case "Divers":
            sumMisc += Math.abs(valueTransaction);
            break;

        }
      }
      lineAccountingRecord++;
    } while (myAccount.line[lineAccountingRecord] != null);

    sum[0] = credit;
    sum[1] = debit;
    sum[2] = sumRent;
    sum[3] = sumFood;
    sum[4] = sumMisc;
    sum[5] = percentage(sumRent, debit);
    sum[6] = percentage(sumFood, debit);
    sum[7] = percentage(sumMisc, debit);
    System.out.println("Somme des crédit : " + credit +
        "€ Somme des débits : " + debit +
        "€\n Somme des loyers : " + sumRent +
        "€\n Somme des Alim : " + sumFood +
        "€\n Somme des divers : " + sumMisc + " €");
    return sum;
  }

  public void printStatisticAccount(Account myAccount) {
    double[] sumArray;

    if (myAccount != null) {
      sumArray = sumTransactions(myAccount);
      double averageRent = percentage(sumArray[2], sumArray[1]);
      double averageFood = percentage(sumArray[3], sumArray[1]);
      double averageMisc = percentage(sumArray[4], sumArray[1]);
      System.out.println("Loyer : " + averageRent + " %\n" +
          "Alimentation : " + averageFood + " %\n" +
          "Divers : " + averageMisc + " %\n");
    }
  }
}
