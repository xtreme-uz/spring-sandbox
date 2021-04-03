package com.example.validation.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.example.validation.error.ErrorType.INVALID;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {

    private Map<String, String> validationErrors;

    public ValidationErrorResponse(Map<String, String> validationErrors) {
        super(INVALID, "error.validation");
        this.validationErrors = validationErrors;
    }
}
