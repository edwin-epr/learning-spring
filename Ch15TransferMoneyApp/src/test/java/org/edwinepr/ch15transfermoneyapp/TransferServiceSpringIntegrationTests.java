package org.edwinepr.ch15transfermoneyapp;

import org.edwinepr.ch15transfermoneyapp.model.Account;
import org.edwinepr.ch15transfermoneyapp.repositories.AccountRepository;
import org.edwinepr.ch15transfermoneyapp.services.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {

    private final long ID_SENDER = 1L;
    private final long ID_RECEIVER = 2L;

    @MockitoBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    public void transferServiceTransferAmountTest() {

        Account sender = new Account();
        sender.setId(ID_SENDER);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(ID_RECEIVER);
        receiver.setAmount(new BigDecimal(2000));

//        when(accountRepository.findById(ID_SENDER))
//                .thenReturn(Optional.of(sender));
        given(accountRepository.findById(ID_SENDER))
                .willReturn(Optional.of(sender));
        when(accountRepository.findById(ID_RECEIVER))
                .thenReturn(Optional.of(receiver));

        transferService
                .transferMoney(ID_SENDER, ID_RECEIVER, new BigDecimal(500));

        verify(accountRepository)
                .changeAmount(1L, new BigDecimal(500));
        verify(accountRepository)
                .changeAmount(2L, new BigDecimal(2500));
    }
}
