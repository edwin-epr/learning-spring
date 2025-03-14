package org.edwinepr.resttemplateapp.controllers;

import lombok.Data;
import org.edwinepr.resttemplateapp.model.Payment;
import org.edwinepr.resttemplateapp.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @PostMapping(path = "/payment")
    public Payment createPayment(
            @RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
