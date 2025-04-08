import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


}

