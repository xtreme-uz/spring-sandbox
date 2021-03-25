package com.example.jpa.service.mapper;

import com.example.jpa.domain.Payment;
import com.example.jpa.service.dto.PaymentTo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mapping(target = "params", source = "params", qualifiedByName = "fromJsonNode")
    PaymentTo toDto(Payment payment);

    @Mapping(target = "params", source = "params", qualifiedByName = "toJsonNode")
    Payment fromDto(PaymentTo dto);

    @Named("toJsonNode")
    static JsonNode toJsonNode(Object object) {
        return OBJECT_MAPPER.valueToTree(object);
    }

    @SneakyThrows
    @Named("fromJsonNode")
    static Object fromJsonNode(JsonNode node) {
        return OBJECT_MAPPER.treeToValue(node, Object.class);
    }

}
