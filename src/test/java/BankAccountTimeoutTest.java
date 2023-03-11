import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)                 // timeout for all the tests in the class
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)                 // timeout for this method
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try{
            Thread.sleep(200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try{
            Thread.sleep(200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(200);                  // sleep is just an example, we should have an actual task here
        });
    }
}
