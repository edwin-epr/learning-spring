package org.edwinepr.ch15transfermoneyapp.services;

import lombok.Data;
import org.edwinepr.ch15transfermoneyapp.exceptions.AccountNotFoundException;
import org.edwinepr.ch15transfermoneyapp.model.Account;
import org.edwinepr.ch15transfermoneyapp.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Data
public class TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {

        Account sender = accountRepository
                .findById(idSender).orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository
                .findById(idReceiver).orElseThrow(AccountNotFoundException::new);


        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
