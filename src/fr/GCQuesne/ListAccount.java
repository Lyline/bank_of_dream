package fr.GCQuesne;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ListAccount {
  private final HashMap<String, Account> listAccount;
  private Account myAccount;

  /**
   * Constructor of the list of this accounts
   *
   * @since 1.0
   */
  public ListAccount() {
    listAccount = new HashMap();
  }

  /**
   * Adds a new account and put on the account's list
   *
   * @param accountType "Épargne" for create a saving account, "Autre" for create a current account or a join account
   * @see Account
   * @since 1.0
   */
  private void addAccount(String accountType) {

    if (accountType == "Épargne") {
      myAccount = new Account("E");
      String key = myAccount.getAccountNumber();
      if (!listAccount.containsKey(key)) listAccount.put(key, myAccount);
      else System.out.println("-- Attention, ce numéro de compte existe déjà, veuillez recommencer --");
    } else if (accountType == "Courant" || accountType == "Joint") {
      myAccount = new Account();
      String key = myAccount.getAccountNumber();
      if (!listAccount.containsKey(key)) listAccount.put(key, myAccount);
      else System.out.println("-- Attention, ce numéro de compte existe déjà, veuillez recommencer --");
    } else System.out.println("-- Impossible de créer un nouveau compte --");
  }

  /**
   * Adds a new accounting record on this account
   *
   * @param accountNumber this number is the account's number to which create a new accounting record
   * @since 1.0
   */
  private void addAccountingRecord(String accountNumber) {
    if (listAccount.containsKey(accountNumber)) {
      myAccount = listAccount.get(accountNumber);
      myAccount.createRecord();
    } else System.out.println("-- Ce compte est inexistant --");
  }

  /**
   * Searchs this account on the list of accounts' recorded
   *
   * @since 1.0
   */
  private void searchAccount() {
    Scanner sc = new Scanner(System.in);
    String accountSearched;
    Account account;

    System.out.println("Saisir un numéro de compte :");
    accountSearched = sc.next();

    if (listAccount.containsKey(accountSearched)) {
      account = listAccount.get(accountSearched);
      account.printAccount();
    } else System.out.println("-- Ce numéro de compte n'existe pas --");
  }

  /**
   * Deletes this account and all its data
   */
  private void deleteAccount() {
    Scanner sc = new Scanner(System.in);
    String accountSearched;
    Account account;

    System.out.println("Saisir le numéro de compte à supprimer :");
    accountSearched = sc.next();

    if (listAccount.containsKey(accountSearched)) {
      listAccount.remove(accountSearched);
      System.out.println("-- Numéro de compte supprimé --");
    } else System.out.println("-- Ce numéro de compte n'existe pas --");
  }

  /**
   * Prints the list of all accounts (current, joint and saving)
   */
  private void printAllAccount() {
    if (listAccount.size() != 0) {
      Collection<Account> c = listAccount.values();
      for (Account element : c) element.printAccount();
    } else System.out.println("-- Il n'y a aucun compte enregistré --");
  }
}
