package org.edwinepr.implrestservice.service;

import org.edwinepr.implrestservice.exceptions.NotEnoughMoneyException;
import org.edwinepr.implrestservice.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {

        throw new NotEnoughMoneyException("Not enough money to make the payment.");
    }
}
