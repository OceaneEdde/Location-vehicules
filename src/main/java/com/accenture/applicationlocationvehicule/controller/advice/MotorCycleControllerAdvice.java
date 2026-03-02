package com.accenture.applicationlocationvehicule.controller.advice;

import com.accenture.applicationlocationvehicule.exception.CarException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MotorCycleControllerAdvice {

    private final MessageSource messageSource;

    public MotorCycleControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CarException.class)
    public ResponseEntity<ErrorDto> businessException(CarException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(
                        java.time.LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()
                )
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> entityNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDto(
                        java.time.LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()
                )
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> notReadable(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(
                        java.time.LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Json invalide : " + e.getMessage()
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorsDto> validationErrors(MethodArgumentNotValidException ex) {

        ErrorsDto errorsDto = new ErrorsDto(
                java.time.LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getAllErrors().stream()
                        .map(error -> new ErrorValidDto(
                                ((FieldError) error).getField(),
                                messageSource.getMessage(error.getDefaultMessage(), null, LocaleContextHolder.getLocale())
                        ))
                        .toList()
        );

        return ResponseEntity.badRequest().body(errorsDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> generic(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(
                        java.time.LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()
                )
        );
    }
}
