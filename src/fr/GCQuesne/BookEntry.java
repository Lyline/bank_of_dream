package fr.GCQuesne;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class BookEntry merge all functionalities for transaction of an account
 *
 * @author GCQuesne
 * @version 1.0
 */
public class BookEntry {
  String transactionPaymentType, transactionTheme, chequeNumber = "";
  long date;
  double transactionValue;

  public void createAccountingRecord() {
    Scanner sc = new Scanner(System.in);

    System.out.println("La somme à créditer (valeur positive) ou à débiter (valeur négative) :");
    transactionValue = sc.useLocale(Locale.US).nextDouble();
    System.out.println("La date de l'opération :");
    date = sc.nextLong();
    System.out.println("Le motif de l'achat ou de la vente [Thème possible : salaire, loyer, alimentation, divers...] :");
    transactionTheme = sc.next();
    System.out.println("Le mode de paiement [Type possible : CB, Numéro du chèque, Virement] :");
    transactionPaymentType = sc.next();

    if (transactionPaymentType.equals("ch") || transactionPaymentType.equals("CH") || transactionPaymentType.equals("Ch")) {
      System.out.println("Saisir le numéro du chèque :");
      chequeNumber = sc.next();
    }
  }

  public void printAccountingRecord() {
    System.out.print("Date : " + date + " - Thème : " + transactionTheme);

    if (transactionValue > 0) System.out.print(" - Crédit : " + transactionValue);
    else System.out.print(" - Débit : " + transactionValue);

    System.out.print("€ - Type de transaction : " + transactionPaymentType);

    if (!chequeNumber.isEmpty()) {
      System.out.print(" - Numéro du chèque : " + chequeNumber);
    }
  }

}
