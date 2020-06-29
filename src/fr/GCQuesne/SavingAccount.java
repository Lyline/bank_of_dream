package fr.GCQuesne;

import java.util.Locale;
import java.util.Scanner;

public class SavingAccount extends Account {
  double accountSavingRate;

  public SavingAccount() {
    super('E');
    accountSavingRate = checkSavingRate();
  }

  public SavingAccount(String emptyValue) {
    super(emptyValue);
  }

  public double getAccountSavingRate() {
    return accountSavingRate;
  }

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

  @Override
  public void printAccount() {
    System.out.println("Nom du client : " + getClientLastName() + "\nPrénom du client : " + getClientFirstName());
    System.out.print("Le compte n° : " + getAccountNumber() + " est un compte Épargne dont le taux de placement est de : " + accountSavingRate + " %");

    if (lineRecorded > 0) {
      line.printAccountingRecord();
      System.out.print("\nValeur du compte : " + getAccountValue() + " €\n");
    } else
      System.out.println("\nValeur initiale : " + accountInitialValue + " €\n\n-- Aucune ligne comptable enregistrée --");
  }
}
