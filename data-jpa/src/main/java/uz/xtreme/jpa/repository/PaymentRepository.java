package uz.xtreme.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.domain.Payment;
import uz.xtreme.jpa.domain.enums.PaymentType;

@Repository
@Transactional(readOnly = true)
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Page<Payment> findAllByType(PaymentType type, Pageable pageable);

}
