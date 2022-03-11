package uz.xtreme.jpa.domain;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.hibernate.Hibernate;
import uz.xtreme.jpa.domain.converters.PaymentParamConverter;
import uz.xtreme.jpa.domain.enums.PaymentType;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Convert(converter = PaymentParamConverter.class)
    @Column(name = "params", columnDefinition = "TEXT")
    private JsonNode params;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Payment payment = (Payment) o;
        return id != null && Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
