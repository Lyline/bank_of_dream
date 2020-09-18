package fr.GCQuesne;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class BookEntry merge all functionalities for transaction of an account
 *
 * @author GCQuesne
 * @version 1.0
 */
public class BookEntry implements Serializable {
  private final String transactionPaymentType;
  private final String transactionTheme;

  private String chequeNumber = "";

  private double transactionValue;
  private final SimpleDateFormat date = new SimpleDateFormat("ddMMyy", Locale.FRENCH);
  private Date dateTransaction = new Date();
  /**
   * Constructor, create a accounting entry's object
   *
   * @since 1.0
   */
  public BookEntry() {
    boolean dateValidator;
    String sdf;
    Scanner sc = new Scanner(System.in);

    System.out.println("La somme à créditer (valeur positive) ou à débiter (valeur négative) :");
    transactionValue = sc.useLocale(Locale.US).nextDouble();
    do {
      System.out.println("La date de l'opération :");
      sdf = sc.next();
      try {
        date.setLenient(false);
        dateTransaction = date.parse(sdf);
        dateValidator = true;
      } catch (ParseException e) {
        System.out.println("Date non conforme");
        dateValidator = false;
      }
    } while (!dateValidator);
    transactionTheme = checkTransactionTheme();
    transactionPaymentType = checkTransactionPaymentType();
    if (transactionPaymentType.equals("Chèque")) {
      System.out.println("Saisir le numéro du chèque :");
      chequeNumber = sc.next();
    }
  }

  /**
   * Getter for the transaction's value
   *
   * @return the value of the transaction
   * @since 1.0
   */
  public double getTransactionValue() {
    return transactionValue;
  }

  public String getTransactionTheme() {
    return transactionTheme;
  }

  /**
   * Setter for the transaction's value
   *
   * @param transactionValue
   * @since 1.0
   */
  public void setTransactionValue(double transactionValue) {
    this.transactionValue = transactionValue;
  }

  /**
   * Prints the line of accounting record : date, theme, credit/debit, the value of transaction and the type of transaction
   *
   * @since 1.0
   */
  public void printAccountingRecord() {
    String temp;
    SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd/MM/yy");
    temp = dateFormatOut.format(dateTransaction);

    System.out.print("\nDate : " + temp + " - Thème : " + transactionTheme);
    if (transactionValue > 0) System.out.print(" - Crédit : " + transactionValue);
    else System.out.print(" - Débit : " + transactionValue);
    System.out.print("€ - Type de transaction : " + transactionPaymentType);
    if (!chequeNumber.isEmpty()) {
      System.out.print(" - Numéro du chèque : " + chequeNumber);
    }
  }

  /**
   * Enters and checks the theme of the transaction : Salary, Rent, Feeding and Miscellaneous
   *
   * @return the theme of the transaction normalize
   */
  private String checkTransactionTheme() {
    char tempIn;
    String tempOut = "";

    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("Le motif de l'achat ou de la vente [Thème : (S)alaire, (L)oyer, (A)limentation, (D)ivers] :");
      tempIn = sc.next().toUpperCase().charAt(0);
      if (tempIn != 'S' && tempIn != 'L' && tempIn != 'A' && tempIn != 'D')
        System.out.println("-- Attention, saisir une valeur valide --");
    } while (tempIn != 'S' && tempIn != 'L' && tempIn != 'A' && tempIn != 'D');

    switch (tempIn) {
      case 'S':
        tempOut = "Salaire";
        break;
      case 'L':
        tempOut = "Loyer";
        break;
      case 'A':
        tempOut = "Alimentation";
        break;
      case 'D':
        tempOut = "Divers";
        break;
    }
    return tempOut;
  }

  /**
   * Enters and checks the type of payment : Credit card, Cheque and Transfer
   *
   * @return the type of payment normalize
   * @since 1.0
   */
  private String checkTransactionPaymentType() {
    char tempIn;
    String tempOut = "";

    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("Le mode de paiement [Type possible : (C)B, c(H)èque, (V)irement] :");
      tempIn = sc.next().toUpperCase().charAt(0);
      if (tempIn != 'C' && tempIn != 'H' && tempIn != 'V')
        System.out.println("-- Attention, saisir une valeur valide --");
    } while (tempIn != 'C' && tempIn != 'H' && tempIn != 'V');

    switch (tempIn) {
      case 'C':
        tempOut = "CB";
        break;
      case 'H':
        tempOut = "Chèque";
        break;
      case 'V':
        tempOut = "Virement";
        break;
    }
    return tempOut;
  }

}
