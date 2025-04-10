public class BankAccount {
    private String FirstName;
    private String LastName;
    private String Pin;
    private Double balance;
    private int Id;
    private static int nextId = 1;

    public BankAccount(String firstName, String lastName, String pin , Double balance) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Pin = pin;
        this.balance = balance;
        this.Id = nextId++;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void deposit(double amount) {
        if(index >= 0 && index < accounts.size()) {
            if (amount > 0) {
                accounts.get(index).deposit(amount);
            }else{
                System.out.println("cannot deposit zero or negative amount");
            }
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

    public boolean verifyPin(String pin) {
        return this.Pin.equals(pin);
    }

    public void changePin(String newPin, String oldPin) {
        if(this.Pin.equals(oldPin)) {
            this.Pin = newPin;
            System.out.println("PIN CHANGED Successfully!");
        }else{
            System.out.println("PIN CHANGE FAILED! Incorrect Old PIN!");
        }

    }





}

