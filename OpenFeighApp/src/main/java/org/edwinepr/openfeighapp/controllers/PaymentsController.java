package org.edwinepr.openfeighapp.controllers;

import lombok.Data;
import org.edwinepr.openfeighapp.model.Payment;
import org.edwinepr.openfeighapp.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Data
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @PostMapping(path = "/payment")
    public Payment createPayment(
            @RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
