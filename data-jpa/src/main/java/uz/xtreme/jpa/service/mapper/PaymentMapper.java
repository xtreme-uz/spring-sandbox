package uz.xtreme.jpa.service.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import uz.xtreme.jpa.domain.Payment;
import uz.xtreme.jpa.service.dto.PaymentTo;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mapping(target = "params", source = "params", qualifiedByName = "fromJsonNode")
    PaymentTo toDto(Payment payment);

    @Mapping(target = "params", source = "params", qualifiedByName = "toJsonNode")
    Payment fromDto(PaymentTo dto);

    default Page<PaymentTo> toDtoPage(Page<Payment> payments) {
        return payments.map(this::toDto);
    }

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
