package fr.GCQuesne;

public class JoinAccount extends Account {
  String firstName, lastName;

  public JoinAccount(String lastNameOfFirstClient, String firstNameOfFirstClient,
                     String lastNameOfSecondClient, String firstNameOfSecondClient,
                     String accountNumber, String initialValue) {
    super(lastNameOfFirstClient, firstNameOfFirstClient, "Joint", accountNumber, initialValue);
    this.firstName = firstNameOfSecondClient;
    this.lastName = lastNameOfSecondClient;
  }
}
