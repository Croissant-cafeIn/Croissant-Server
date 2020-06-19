package com.cafein.croissants.web.controller.advice;

import com.cafein.croissants.web.dao.domain.exception.PasswordMismatchException;
import com.cafein.croissants.web.service.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class, PasswordMismatchException.class})
    public ResponseEntity<ErrorMessageDto> handleClientNotFound(Exception ex) {
        return new ResponseEntity<>(new ErrorMessageDto(ex.getMessage()), HttpStatus.FORBIDDEN);
    }
}
