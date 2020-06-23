package fr.GCQuesne;
/**
 * Calcule la moyenne du nombre de paiements par carte bancaire, par chèque et par virement
 *
 * @author GCQuesne
 * @version 1.0
 */

import java.util.Scanner;

public class Statistique {

    public static void main(String[] args) {

        int numberCreditCard,
                numberCheque,
                numberTransfer;

        double totalOrder,
                averageCreditCard,
                averageCheque,
                averageTransfer;

        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre de paiements par carte bancaire :");
        numberCreditCard = sc.nextInt();
        System.out.println("Nombre de chèques émis :");
        numberCheque = sc.nextInt();
        System.out.println("Nombre de virements automatique :");
        numberTransfer = sc.nextInt();

        totalOrder = numberCreditCard + numberCheque + numberTransfer;
        averageCreditCard = numberCreditCard * 100 / totalOrder;
        averageCheque = numberCheque * 100 / totalOrder;
        averageTransfer = numberTransfer * 100 / totalOrder;

        System.out.println("Vous avez émis" + totalOrder + "ordres de débits :\n" +
                "dont : " + averageCreditCard + "% par Carte bancaire\n" +
                "       " + averageCheque + "% par cheque\n" +
                "       " + averageTransfer + "% par virement");

    }
}
