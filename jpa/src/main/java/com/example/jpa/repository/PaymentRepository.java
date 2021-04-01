package com.example.jpa.repository;

import com.example.jpa.domain.Payment;
import com.example.jpa.domain.enums.PaymentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Page<Payment> findAllByType(PaymentType type, Pageable pageable);

}
