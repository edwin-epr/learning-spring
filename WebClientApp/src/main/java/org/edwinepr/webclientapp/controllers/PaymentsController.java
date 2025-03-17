package org.edwinepr.webclientapp.controllers;

import lombok.Data;
import org.edwinepr.webclientapp.model.Payment;
import org.edwinepr.webclientapp.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@Data
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
