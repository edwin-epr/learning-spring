package org.edwinepr.implrestservice.controllers.advice;

import org.edwinepr.implrestservice.exceptions.NotEnoughMoneyException;
import org.edwinepr.implrestservice.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoney(NotEnoughMoneyException exception) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
