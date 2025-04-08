public class BankAccount {
    private String FirstName;
    private String LastName;
    private String Pin;
    private Double balance;

    public BankAccount(String firstName, String lastName, String pin , Double balance) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Pin = pin;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }
    public void withdraw(double amount) {
        if(amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }


}

