package com.devsu.hackerearth.backend.account;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import com.devsu.hackerearth.backend.account.model.dto.AccountDto;

public class SampleTest {

    @Test
    public void testAccountDtoCreation() {
        // Crear DTO y asignar valores
        AccountDto dto = new AccountDto();
        dto.setNumber("123456"); // getter/setter compatible con Account
        dto.setType("Ahorros");
        dto.setInitialAmount(BigDecimal.valueOf(500.0)); // BigDecimal
        dto.setIsActive(true);

        // Validaciones
        assertEquals("123456", dto.getNumber());
        assertEquals("Ahorros", dto.getType());
        assertTrue(dto.getIsActive());
        assertEquals(0, dto.getInitialAmount().compareTo(BigDecimal.valueOf(500.0)));
    }
}
