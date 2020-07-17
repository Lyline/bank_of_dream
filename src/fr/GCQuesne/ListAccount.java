package fr.GCQuesne;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ListAccount implements Serializable {
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
   * @see Account
   * @since 1.0
   */
  public void addAccount() {
    char accountType;
    Scanner sc = new Scanner(System.in);

    System.out.println("Créer un compte de type (E)pargne ou (A)utre ?");
    accountType = sc.next().toUpperCase().charAt(0);

    if (accountType == 'E') {
      myAccount = new SavingAccount();
      String key = myAccount.getAccountNumber();
      if (!listAccount.containsKey(key)) listAccount.put(key, myAccount);
      else System.out.println("-- Attention, ce numéro de compte existe déjà, veuillez recommencer --");
    } else if (accountType == 'A') {
      myAccount = new Account();
      String key = myAccount.getAccountNumber();
      if (!listAccount.containsKey(key)) listAccount.put(key, myAccount);
      else System.out.println("-- Attention, ce numéro de compte existe déjà, veuillez recommencer --");
    } else System.out.println("-- Impossible de créer un nouveau compte --");
  }

  /**
   * Adds a new accounting record on this account
   *
   * @since 1.0
   */
  public void addAccountingRecord() {
    String accountNumber = searchAccount();
    if (listAccount.containsKey(accountNumber)) myAccount.createRecord();
    else System.out.println("-- Ce compte est inexistant --");
  }

  /**
   * Searchs this account on the list of accounts' recorded
   *
   * @since 1.0
   */
  public String searchAccount() {
    Scanner sc = new Scanner(System.in);
    String accountSearched;
    Account account;

    System.out.println("Saisir un numéro de compte :");
    accountSearched = sc.next();

    if (listAccount.containsKey(accountSearched)) {
      account = listAccount.get(accountSearched);
      accountSearched = account.getAccountNumber();
    } else System.out.println("-- Ce numéro de compte n'existe pas --");
    return accountSearched;
  }

  /**
   * Deletes this account and all its data
   */
  public void deleteAccount() {
    Scanner sc = new Scanner(System.in);
    String accountSearched;

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
  public void printAllAccounts() {
    if (listAccount.size() != 0) {
      Collection<Account> c = listAccount.values();
      for (Account element : c) element.printAccount();
    } else System.out.println("-- Il n'y a aucun compte enregistré --");
  }

  public void printAccount(String temp) {
    Account account = listAccount.get(temp);
    account.printAccount();
  }
}
