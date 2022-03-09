package uz.xtreme.jpa.domain.converters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentParamConverter implements AttributeConverter<JsonNode, String> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(JsonNode attribute) {
        return attribute.toPrettyString();
    }

    @Override
    @SneakyThrows
    public JsonNode convertToEntityAttribute(String dbData) {
        return OBJECT_MAPPER.readTree(dbData);
    }
}
