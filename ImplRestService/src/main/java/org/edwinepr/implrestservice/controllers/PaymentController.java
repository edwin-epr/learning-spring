package org.edwinepr.implrestservice.controllers;

import lombok.RequiredArgsConstructor;
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
         PaymentDetails paymentDetails = paymentService.processPayment();

         return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
        }
}
