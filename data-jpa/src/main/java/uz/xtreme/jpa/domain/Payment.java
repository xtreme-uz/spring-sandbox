package uz.xtreme.jpa.domain;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.xtreme.jpa.domain.converters.PaymentParamConverter;
import uz.xtreme.jpa.domain.enums.PaymentType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
