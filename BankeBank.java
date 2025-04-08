import java.util.ArrayList;
import java.util.List;

public class BankeBank {

    List<BankAccount> accounts = new ArrayList<>();


    public void createAccount(String FirstName, String LastName, String Pin , Double balance) {
        BankAccount Account = new BankAccount(FirstName,LastName,Pin ,balance);
        accounts.add(Account);
    }

    public void deposit(int index,double amount) {
        if(index >= 0 && index < accounts.size()) {
            accounts.get(index).deposit(amount);
        }
    }
    public void withdraw(int index,double amount) {
        if(index >= 0 && index < accounts.size()) {
            accounts.get(index).withdraw(amount);
        }
    }

    public double checkBalance(int index) {
        if(index >= 0 && index < accounts.size()) {
            return accounts.get(index).getBalance();
        }
        return -1.0;
    }
}


