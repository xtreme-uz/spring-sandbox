package com.example.validation.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ErrorResponse {

    private ErrorType type;

    private String messageCode;

    protected ErrorResponse(ErrorType type, String messageCode) {
        this.type = type;
        this.messageCode = messageCode;
    }
}
