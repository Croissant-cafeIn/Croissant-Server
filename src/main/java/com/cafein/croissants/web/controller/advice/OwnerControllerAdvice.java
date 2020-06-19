package com.cafein.croissants.web.controller.advice;

import com.cafein.croissants.web.dao.domain.exception.PasswordMismatchException;
import com.cafein.croissants.web.service.exception.ClientNotFoundException;
import com.cafein.croissants.web.service.exception.OwnerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OwnerControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({OwnerNotFoundException.class, PasswordMismatchException.class})
    public ResponseEntity<ErrorMessageDto> handleOwnerNotFound(Exception ex) {
        return new ResponseEntity<>(new ErrorMessageDto(ex.getMessage()), HttpStatus.FORBIDDEN);
    }
}
