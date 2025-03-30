package org.edwinepr.ch15transfermoneyapp;

import org.edwinepr.ch15transfermoneyapp.model.Account;
import org.edwinepr.ch15transfermoneyapp.repositories.AccountRepository;
import org.edwinepr.ch15transfermoneyapp.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow() {

        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId()))
                .willReturn(Optional.of(receiver));

        transferService.transferMoney(1L, 2L, new BigDecimal(300));

        verify(accountRepository).changeAmount(1L, new BigDecimal(700));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1300));
    }
}
