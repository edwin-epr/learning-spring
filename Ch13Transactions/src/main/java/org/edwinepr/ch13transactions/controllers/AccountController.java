package org.edwinepr.ch13transactions.controllers;

import lombok.Data;
import org.edwinepr.ch13transactions.dto.TransferRequest;
import org.edwinepr.ch13transactions.model.Account;
import org.edwinepr.ch13transactions.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class AccountController {

    private final TransferService transferService;

    @PostMapping(path = "/transfer")
    public void transfer(@RequestBody TransferRequest request) {

        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping(path = "/accounts")
    public List<Account> findAllAccounts() {
        return transferService.findAllAccounts();
    }
}
