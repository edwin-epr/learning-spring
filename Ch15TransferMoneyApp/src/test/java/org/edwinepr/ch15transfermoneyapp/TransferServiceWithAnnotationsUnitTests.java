package org.edwinepr.ch15transfermoneyapp;

import org.edwinepr.ch15transfermoneyapp.exceptions.AccountNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

    private final long ID_SENDER = 1L;
    private final long ID_RECEIVER = 2L;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow() {

        Account sender = new Account();
        sender.setId(ID_SENDER);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(ID_RECEIVER);
        receiver.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(ID_SENDER))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(ID_RECEIVER))
                .willReturn(Optional.of(receiver));

        transferService.transferMoney(ID_SENDER, ID_RECEIVER, new BigDecimal(300));

        verify(accountRepository).changeAmount(ID_SENDER, new BigDecimal(700));
        verify(accountRepository).changeAmount(ID_RECEIVER, new BigDecimal(1300));
    }

    @Test
    public void moneyTransferReceiverAccountNotFoundFlow() {

        Account sender = new Account();
        sender.setId(ID_SENDER);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(ID_SENDER))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(ID_RECEIVER))
                .willReturn(Optional.empty());

        assertThrows(
                AccountNotFoundException.class,
                () -> transferService.transferMoney(ID_SENDER, ID_RECEIVER, new BigDecimal(100))
        );

        verify(accountRepository, never())
                .changeAmount(anyLong(), any());
    }
}
