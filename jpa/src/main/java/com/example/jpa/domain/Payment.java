package com.example.jpa.domain;

import com.example.jpa.domain.converters.PaymentParamConverter;
import com.example.jpa.domain.enums.PaymentType;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private JsonNode params;

}
