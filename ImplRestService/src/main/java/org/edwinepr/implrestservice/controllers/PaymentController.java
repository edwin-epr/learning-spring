package org.edwinepr.implrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.edwinepr.implrestservice.model.PaymentDetails;
import org.edwinepr.implrestservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    @PostMapping(path = "/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails
    ) {
        LOGGER.info("Received payment for " + paymentDetails.getAmount());
         return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
        }
}
