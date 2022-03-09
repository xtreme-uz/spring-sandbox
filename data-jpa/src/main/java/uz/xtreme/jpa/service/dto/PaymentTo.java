package uz.xtreme.jpa.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.xtreme.jpa.domain.enums.PaymentType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTo {

    private Long id;
    private PaymentType type;
    private Object params;

    public PaymentTo(PaymentType type, Object params) {
        this.type = type;
        this.params = params;
    }
}
