import java.util.ArrayList;
import java.util.List;

public class BankeBank {

    List<BankAccount> accounts = new ArrayList<>();


    public void createAccount(String FirstName, String LastName, String Pin , Double balance) {
        BankAccount Account = new BankAccount(FirstName,LastName,Pin ,balance);
        accounts.add(Account);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount
        }
    }

    public double checkBalance( double balance)
    {
        return balance;
    }


}


