package org.edwinepr.openfeighapp.proxy;

import org.edwinepr.openfeighapp.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments",
            url = "${name.service.url}")
public interface PaymentsProxy {

    @PostMapping(path = "/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}
