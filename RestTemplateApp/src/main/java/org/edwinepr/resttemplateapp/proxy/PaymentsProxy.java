package org.edwinepr.resttemplateapp.proxy;

import lombok.Data;
import org.edwinepr.resttemplateapp.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Data
public class PaymentsProxy {

    private final RestTemplate rest;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public Payment createPayment(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId",
                UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity =
                new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> response =
                rest.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        Payment.class);

        return response.getBody();
    }
}
