package com.example.jpa.service.impl;

import com.example.jpa.domain.Payment;
import com.example.jpa.repository.PaymentRepository;
import com.example.jpa.service.PaymentService;
import com.example.jpa.service.dto.PaymentTo;
import com.example.jpa.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public PaymentTo create(PaymentTo dto) {
        Payment payment = mapper.fromDto(dto);
        Payment save = repository.save(payment);
        return mapper.toDto(save);
    }

}
