package org.edwinepr.implrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.edwinepr.implrestservice.exceptions.NotEnoughMoneyException;
import org.edwinepr.implrestservice.model.ErrorDetails;
import org.edwinepr.implrestservice.model.PaymentDetails;
import org.edwinepr.implrestservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path = "/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException exception) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage(exception.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
