package org.edwinepr.ch15transfermoneyapp;

import org.edwinepr.ch15transfermoneyapp.controllers.AccountController;
import org.edwinepr.ch15transfermoneyapp.dto.TransferRequest;
import org.edwinepr.ch15transfermoneyapp.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private TransferService transferService;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void happyFlowTransferMoneyTest() {

        TransferRequest request = new TransferRequest();
        request.setSenderAccountId(1L);
        request.setReceiverAccountId(2L);
        request.setAmount(BigDecimal.valueOf(100));

        accountController.transferMoney(request);

        verify(transferService).transferMoney(
                1L,
                2L,
                BigDecimal.valueOf(100)
        );
    }

//    @Test
//    public void transferMoneyThrowAccountNotFoundTest() {
//
//        TransferRequest request = new TransferRequest();
//        request.setSenderAccountId(3L);
//        request.setReceiverAccountId(2L);
//        request.setAmount(BigDecimal.valueOf(100));
//
//        doThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR))
//                .when(transferService).transferMoney(
//                        request.getSenderAccountId(),
//                        request.getReceiverAccountId(),
//                        request.getAmount()
//                );
//
//        assertThrows(ResponseStatusException.class,
//                () -> accountController.transferMoney(request));
//    }
}
