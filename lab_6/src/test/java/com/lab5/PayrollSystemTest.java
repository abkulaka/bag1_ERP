package com.lab5;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PayrollSystemTest {

    @Test
    public void testAddProductWithNegativeQuantity() {
        PayrollSystem ps = new PayrollSystem();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ps.addProduct(-1);
        });
        
        assert(thrown.getMessage().contains("сөрөг"));
    }
}
