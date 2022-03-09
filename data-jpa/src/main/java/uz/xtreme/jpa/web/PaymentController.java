package uz.xtreme.jpa.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.jpa.domain.enums.PaymentType;
import uz.xtreme.jpa.service.PaymentService;
import uz.xtreme.jpa.service.dto.PaymentTo;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public PaymentTo create(@RequestBody PaymentTo payment) {
        return service.create(payment);
    }

    @GetMapping
    public Page<PaymentTo> getAll(@RequestParam PaymentType type, Pageable pageable) {
        return service.getAll(type, pageable);
    }

}
