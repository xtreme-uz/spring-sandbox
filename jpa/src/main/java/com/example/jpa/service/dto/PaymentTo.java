package com.example.jpa.service.dto;

import com.example.jpa.domain.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
