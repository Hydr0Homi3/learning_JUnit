import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest { // if the assumption is not met, the test will be aborted. Can be overloaded

    @Test
    @DisplayName("Test activation account after creation")
    public void testIsActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        //assumeTrue(bankAccount != null);
        //assertTrue(bankAccount.isActive());
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}
