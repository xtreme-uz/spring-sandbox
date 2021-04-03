package com.example.validation.web;

import com.example.validation.error.ErrorResponse;
import com.example.validation.error.ValidationErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.nullSafeToString;

@Log4j2
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
        log.warn("Method argument not valid exception on request '{}'", req.getRequestURL(), ex);
        return new ValidationErrorResponse(ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, err -> nullSafeToString(err.getDefaultMessage()))));
    }

}
