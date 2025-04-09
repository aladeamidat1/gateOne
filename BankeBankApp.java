import java.util.Scanner;

public class BankeBankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankeBank bank = new BankeBank();
        int loggedInIndex = -1;

        System.out.println("Welcome to BANKE ATM APP");
        System.out.println("-----------------------------");

        while(true) {
            System.out.println("\n=======MAIN MENU======");
            System.out.println("1. Create Account");
            System.out.println("2. Access Bank Services");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice1 = input.nextInt();
            input.nextLine();

            if (choice1 == 1) {
                System.out.println("Enter your First Name: ");
                String firstName = input.nextLine().trim();
                if(firstName.isEmpty()) {
                    System.out.println("First name cannot be empty!. ");
                    continue;
                }

                System.out.println("Enter your Last Name: ");
                String lastName = input.nextLine().trim();
                if(lastName.isEmpty()) {
                    System.out.println("Last name cannot be empty!. ");
                    continue;
                }

                System.out.println("Set Your Pin(at least 4 digits): ");
                String pin = input.nextLine().trim();
                if(pin.length() < 4 || pin.isEmpty()) {
                    System.out.println("Pin cannot be empty! and must be at least 4 digits!. ");
                    continue;
                }

                System.out.println("Enter any amount to deposit: ");
                double amount = input.nextDouble();
                input.nextLine();

                bank.createAccount(firstName, lastName, pin, amount);
                int newAccountId = bank.accounts.get(bank.accounts.size() -1).getId();
                System.out.println("Your account has been created successfully! ");
                System.out.println("your account ID is: " + newAccountId);
            }

            else if (choice1 == 2) {
                System.out.println("Enter your pin to login: ");
                    String pin = input.nextLine();

                    loggedInIndex = -1;
                    for(int i = 0; i < bank.accounts.size(); i++){
                        if(bank.accounts.get(i).verifyPin(pin)){
                            loggedInIndex = i;
                            break;
                        }
                    }
                    if(loggedInIndex == -1){
                        System.out.println("PIN NOT VERIFIED! Login failed!");
                        continue;
                    }
                    System.out.println("PIN VERIFIED! Login successful!");
                    System.out.println("Your account ID is: " + bank.accounts.get(loggedInIndex).getId());


                    while (true) {
                    System.out.println("\n ============ MENU =============");
                    System.out.println("1. Check Balance");
                    System.out.println("2.Deposit");
                    System.out.println("3.Withdraw");
                    System.out.println("4. Change Pin");
                    System.out.println("5. Close Account");
                    System.out.println("6. Exit");
                    System.out.println("7. logout");
                    System.out.println("Enter your Choice: ");
                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice){
                        case 1:
                            System.out.println("Your balance is:  #" +  bank.checkBalance(loggedInIndex));
                            break;

                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            double amount = input.nextDouble();
                            bank.deposit(loggedInIndex, amount);
                            System.out.println("Deposit successful!");
                            break;

                        case 3:
                            System.out.println("Enter amount to withdraw: ");
                            double withdrawAmount = input.nextDouble();
                            bank.withdraw(loggedInIndex, withdrawAmount);
                            System.out.println("Withdraw successful!");
                            break;

                        case 4:
                            System.out.println("Enter current PIN: ");
                            String oldPin = input.nextLine();
                            System.out.println("Enter new PIN: ");
                            String newPin = input.nextLine();
                            bank.changePin(loggedInIndex, oldPin, newPin);
                            System.out.println("Change PIN successful!");
                            break;

                        case 5:
                            System.out.println("Enter your PIN to close account: ");
                            String comfirmPin = input.nextLine();
                            bank.closeAccount(loggedInIndex, comfirmPin);
                            loggedInIndex = -1;
                            break;

                        case 6:
                            System.out.println("Enter recipient's Account ID: ");
                            int recipientId = input.nextInt();
                            input.nextLine();

                            int recipientIndex;
                            recipientIndex = bank.findAccountById(recipientId);
                            if(recipientIndex == -1 || recipientIndex == loggedInIndex){
                                System.out.println("Recipient ID does not exist!");
                                break;
                            }
                            System.out.println("Enter amount to transfer: ");
                            double transferAmount = input.nextDouble();

                            if(bank.checkBalance(loggedInIndex) >= transferAmount && transferAmount > 0){
                                bank.withdraw(loggedInIndex, transferAmount);
                                bank.deposit(recipientIndex, transferAmount);
                                System.out.println("Transfer successful!");
                            }else{
                                System.out.println("Transfer failed! Not enough balance!");
                            }
                            break;
                        case 7:
                            System.out.println("Logged out successfully!");
                            loggedInIndex = -1;
                            break;

                        default:
                            System.out.println("Invalid choice! Try again!");


                    }
                    if (choice == 5 || choice == 7) break;

                }
            }
            else if (choice1 == 3) {
                System.out.println("Thank you for using BANKE ATM APP");
                break;
            }
            else{
                System.out.println("Invalid choice! Please try again!");
            }
        }
    }

}