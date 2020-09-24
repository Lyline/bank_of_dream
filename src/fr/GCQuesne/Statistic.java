package fr.GCQuesne;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sets, calculates and gets the average of order's type (credit card, cheque and transfer)
 *
 * @author GCQuesne
 * @version 1.0
 */

public class Statistic {
  static double numberCreditCard,
      numberCheque,
      numberTransfer,
      totalOrder;

  static double averageCreditCard,
      averageCheque,
      averageTransfer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Nombre de paiements par carte bancaire :");
    numberCreditCard = sc.nextInt();
    System.out.println("Nombre de chèques émis :");
    numberCheque = sc.nextInt();
    System.out.println("Nombre de virements automatique :");
    numberTransfer = sc.nextInt();

    totalOrder = numberCreditCard + numberCheque + numberTransfer;
    averageCreditCard = percentage(numberCreditCard, totalOrder);
    averageCheque = percentage(numberCheque, totalOrder);
    averageTransfer = percentage(numberTransfer, totalOrder);

    System.out.println("Vous avez émis " + totalOrder + " ordres de débits :\n" +
        "dont : " + averageCreditCard + "% par Carte bancaire\n" +
        "       " + averageCheque + "% par cheque\n" +
        "       " + averageTransfer + "% par virement");

  }

  /**
   * Calculate the average of this order's type (credit card, cheque or transfer)
   *
   * @param sumType the total number's order for this type
   * @return the average of this type by total order of all types
   */
  public static double percentage(double sumType, double totalType) {
    if (sumType != 0) {
      double result = sumType * 100 / totalType;
      return result;
    } else return 0;
  }

}
