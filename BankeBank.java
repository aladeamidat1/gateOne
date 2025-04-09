import java.util.ArrayList;
import java.util.List;

public class BankeBank {

    List<BankAccount> accounts = new ArrayList<>();


    public void createAccount(String FirstName, String LastName, String Pin , Double balance) {
        BankAccount Account = new BankAccount(FirstName,LastName,Pin ,balance);
        accounts.add(Account);
    }

    public void closeAccount(int index,String pin) {
       if(index >= 0 && index < accounts.size()){
           BankAccount account = accounts.get(index);
           if(account.verifyPin(pin)){
               accounts.remove(index);
               System.out.println("Your Account Has Been Closed  Successfully!");
           }else{
               System.out.println("Incorrect Old PIN!");
           }
       }else{
           System.out.println("Invalid Account!");
       }
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
    public void changePin(int index,String oldPin,String newPin) {
        if(index >= 0 && index < accounts.size()) {
            accounts.get(index).changePin(oldPin,newPin);
        }
    }
    public int findAccountById(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}


