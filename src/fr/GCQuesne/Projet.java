package fr.GCQuesne;

import java.util.Scanner;

/**
 * Main file of application
 *
 * @author GCQuesne
 * @version 1.0
 */
public class Projet {
    public static void main(String[] args) {
        long accountNumber;
        char accountType, paymentTheme, paymentType;
        double accountValue, date;

        Scanner sc = new Scanner(System.in);

        System.out.println("1 Créer un compte\n" +
                "2 Afficher un compte\n" +
                "3 Crée une ligne comptabe\n" +
                "4 Sortir\n" +
                "5 De l'aide\n" +
                "Votre choix :");

        int selectionMenu = sc.nextInt();

        System.out.println("Type du compte [Type possible : courant, joint, épargne] :\n" +
                "Numéro de compte :\n" +
                "Première valeur créditée :\n" +
                "Taux de placement :\n");

        System.out.println("Saisir le numéro de compte :");
        long accountNumberCheck = sc.nextLong();

        System.out.println("Option non programmée");

        System.out.println("System.exit(0)");

        System.out.println("Créer un compte : Ouverture d'un nouveau compte\n" +
                "Afficher un compte : Consulter un compte existant\n" +
                "Créer une ligne comptable : Ajoute un mouvement bancaire sur un compte\n" +
                "Sortir : Fermer l'application\n" +
                "De l'aide : Affiche un menu d'aide");
    }
}
