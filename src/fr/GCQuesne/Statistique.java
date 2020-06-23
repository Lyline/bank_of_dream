package fr.GCQuesne;
/**
 * Calcule la moyenne du nombre de paiements par carte bancaire, par chèque et par virement
 *
 * @author GCQuesne
 * @version 1.0
 */

import java.util.Scanner;

public class Statistique {
  static int numberCreditCard,
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
    averageCreditCard = percentage(numberCreditCard);
    averageCheque = percentage(numberCheque);
    averageTransfer = percentage(numberTransfer);

    System.out.println("Vous avez émis " + totalOrder + " ordres de débits :\n" +
        "dont : " + averageCreditCard + "% par Carte bancaire\n" +
        "       " + averageCheque + "% par cheque\n" +
        "       " + averageTransfer + "% par virement");

  }

  public static double percentage(int numberOrderType) {
    return numberOrderType * 100 / (double) totalOrder;
  }
}
