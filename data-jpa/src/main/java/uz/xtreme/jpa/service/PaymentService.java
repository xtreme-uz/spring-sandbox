package uz.xtreme.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.xtreme.jpa.domain.enums.PaymentType;
import uz.xtreme.jpa.service.dto.PaymentTo;

public interface PaymentService {
    PaymentTo create(PaymentTo dto);

    Page<PaymentTo> getAll(PaymentType type, Pageable pageable);
}
