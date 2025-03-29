package org.edwinepr.ch14electronicwallet.controllers;

import lombok.Data;
import org.edwinepr.ch14electronicwallet.dto.TransferRequest;
import org.edwinepr.ch14electronicwallet.model.Account;
import org.edwinepr.ch14electronicwallet.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
public class AccountController {

    private final TransferService transferService;

    @PostMapping(path = "/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request) {

        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping(path = "/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name) {

        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
