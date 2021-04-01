package com.example.jpa.service;

import com.example.jpa.domain.enums.PaymentType;
import com.example.jpa.repository.PaymentRepository;
import com.example.jpa.service.dto.PaymentTo;
import com.example.jpa.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public PaymentTo create(PaymentTo dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public Page<PaymentTo> getAll(PaymentType type, Pageable pageable) {
        return mapper.toDtoPage(repository.findAllByType(type, pageable));
    }

}
