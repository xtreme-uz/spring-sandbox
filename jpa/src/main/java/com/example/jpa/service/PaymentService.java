package com.example.jpa.service;


import com.example.jpa.domain.enums.PaymentType;
import com.example.jpa.service.dto.PaymentTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {
    PaymentTo create(PaymentTo dto);

    Page<PaymentTo> getAll(PaymentType type, Pageable pageable);
}
