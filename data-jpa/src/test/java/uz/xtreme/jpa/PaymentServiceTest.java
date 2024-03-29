package uz.xtreme.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import uz.xtreme.jpa.service.PaymentService;
import uz.xtreme.jpa.service.dto.PaymentTo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static uz.xtreme.jpa.domain.enums.PaymentType.ONLINE;

@SpringBootTest
@ActiveProfiles("test")
class PaymentServiceTest {

    @Autowired
    PaymentService service;

    @Test
    void create() {
        SimplePayment params = new SimplePayment("paypal", BigDecimal.valueOf(1));
        PaymentTo given = new PaymentTo(ONLINE, params);

        PaymentTo actual = service.create(given);

        LinkedHashMap<String, Object> expectedParams = new LinkedHashMap<>();
        expectedParams.put("provider", "paypal");
        expectedParams.put("amount", BigDecimal.valueOf(1));
        PaymentTo expected = new PaymentTo(1L, ONLINE, expectedParams);

        assertThat(actual).usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expected);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class SimplePayment {
        private String provider;
        private BigDecimal amount;
    }

}
