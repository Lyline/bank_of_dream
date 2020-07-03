package fr.GCQuesne;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class SavingAccount merge all functionalities SavingAccount's object extends of the class Account
 *
 * @author GCQuesne
 * @version 1.0
 */

public class SavingAccount extends Account {
  double accountSavingRate;

  /**
   * Constructor : create a SavingAccount's object without parameter
   * <ul>
   *  <li>The last name of this client</li>
   *  <li>The first name of this client</li>
   *  <li>The number</li>
   *  <li>The type (Current, Join or Saving)</li>
   *  <li>The initial value</li>
   *  <li>The rate of the account saving</li>
   *  <li>The number of accounting entry equals at 0</li>
   * </ul>
   *
   * @see Account
   * @since 1.0
   */
  public SavingAccount() {
    super('E');
    accountSavingRate = checkSavingRate();
  }

  /**
   * Constructor : create a SavingAccount's object with one parameter
   *
   * @param emptyValue the number of this account
   * @see Account
   * @since 1.0
   */
  public SavingAccount(String emptyValue) {
    super(emptyValue);
  }

  /**
   * Gets the saving rate of this account
   *
   * @return current value of the saving rate
   */
  public double getAccountSavingRate() {
    return accountSavingRate;
  }

  /**
   * Sets and checks the saving rate always positive, for creation a new saving account's object
   *
   * @return the saving rate
   * @see SavingAccount
   * @see Account
   * @since 1.0
   */
  private double checkSavingRate() {
    double temp;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("Saisir le taux de placement:");
      temp = sc.useLocale(Locale.US).nextDouble();
      if (temp < 0) System.out.println("-- Attention, saisir une valeur positive --");
    } while (temp < 0);
    return temp;
  }

  /**
   * Prints the saving account's data of this account
   */
  @Override
  public void printAccount() {
    System.out.println("Nom du client : " + getClientLastName() + "\nPrénom du client : " + getClientFirstName());
    System.out.print("Le compte n° : " + getAccountNumber() + " est un compte Épargne dont le taux de placement est de : " + accountSavingRate + " %");

    if (lineRecorded >= 0) {
      for (int i = 0; i <= lineRecorded; i++) {
        line[i].printAccountingRecord();
      }
      System.out.print("\nValeur du compte : " + getAccountValue() + " €\n");
    } else
      System.out.println("\nValeur initiale : " + accountInitialValue + " €\n\n-- Aucune ligne comptable enregistrée --");
  }
}
