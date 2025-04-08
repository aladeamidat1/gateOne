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
        assertEquals(100, banks.checkBalance(0));
    }

}

