import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBankeBank {
    BankeBank banks = new BankeBank();


    @Test
    public void testCreateAccount(){
        banks.createAccount("alade", "ameedah", "1234", 0.0 );
        assertEquals(1, banks.accounts.size());

    }
    @Test
    public void testDeposit(){
        banks.createAccount("alade", "ameedah", "1234", 0.0 );
        banks.deposit(0, 100.0);
        assertEquals(100.0, banks.checkBalance(0));
    }
    @Test
    public void testDepositNegativeAmount(){
        banks.createAccount("alade","ameedah","1234",50.0);
        banks.deposit(0,-30.0);
        assertEquals(50.0, banks.checkBalance(0));
    }
    @Test
    public void testDepositInvalidAccount(){
        banks.deposit(10,100.0);
        assertEquals(-1.0, banks.checkBalance(10));
    }
    @Test
    public void testWithdraw(){
        banks.createAccount("alade", "ameedah", "1234", 200.0 );
        banks.withdraw(0, 100.0);
        assertEquals(100.0, banks.checkBalance(0));
    }
    @Test
    public void testWithdrawNegativeAmount(){
        banks.createAccount("alade", "ameedah", "1234", 100.0 );
        banks.withdraw(0, -30.0);
        assertEquals(100.0, banks.checkBalance(0));
    }
    @Test
    public void testChangePinSuccess() {
        banks.createAccount("alade", "amidat", "5555", 300.0);
        banks.changePin(0, "5555", "7777");
        assertTrue(banks.accounts.get(0).verifyPin("7777"));
    }
    @Test
    public void testChangePinFail() {
        banks.createAccount("Emeka", "Chuks", "8888", 300.0);
        banks.changePin(0, "wrongpin", "9999");
        assertFalse(banks.accounts.get(0).verifyPin("9999"));
        assertTrue(banks.accounts.get(0).verifyPin("8888"));
    }
    @Test
    public void testCloseAccountWithCorrectPin() {
        banks.createAccount("Jane", "Doe", "0000", 100.0);
        banks.closeAccount(0, "0000");
        assertEquals(0, banks.accounts.size());
    }
    @Test
    public void testCloseAccountWithWrongPin() {
        banks.createAccount("John", "Smith", "4321", 100.0);
        banks.closeAccount(0, "9999");
        assertEquals(1, banks.accounts.size());
    }
    @Test
    public void testTransferBetweenAccounts() {
        banks.createAccount("Alice", "Wonder", "0001", 200.0); // index 0
        banks.createAccount("Bob", "Builder", "0002", 100.0);  // index 1
        int from = 0;
        int to = banks.findAccountById(banks.accounts.get(1).getId());

        banks.withdraw(from, 50.0);
        banks.deposit(to, 50.0);

        assertEquals(150.0, banks.checkBalance(1));
        assertEquals(150.0, banks.checkBalance(0));
    }


}

