package uz.xtreme.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.xtreme.jpa.domain.enums.PaymentType;
import uz.xtreme.jpa.repository.PaymentRepository;
import uz.xtreme.jpa.service.dto.PaymentTo;
import uz.xtreme.jpa.service.mapper.PaymentMapper;

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
