package org.edwinepr.ch15transfermoneyapp;

import org.edwinepr.ch15transfermoneyapp.model.Account;
import org.edwinepr.ch15transfermoneyapp.repositories.AccountRepository;
import org.edwinepr.ch15transfermoneyapp.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TransferServiceUnitTests {

	private final long ID_SENDER = 1L;
	private final long ID_RECEIVER = 2L;

	@Test
	@DisplayName("Test the amount is transferred " +
	"from one account to another if no exception occurs.")
	public void moneyTransferHappyFlow() {
		AccountRepository accountRepository =
				mock(AccountRepository.class);

		TransferService transferService =
				new TransferService(accountRepository);

		Account sender = new Account();
		sender.setId(ID_SENDER);
		sender.setAmount(new BigDecimal("1000"));

		Account receiver = new Account();
		receiver.setId(ID_RECEIVER);
		receiver.setAmount(new BigDecimal("1000"));

		given(accountRepository.findById(ID_SENDER))
				.willReturn(Optional.of(sender));

		given(accountRepository.findById(ID_RECEIVER))
				.willReturn(Optional.of(receiver));

		transferService.transferMoney(
				ID_SENDER,
				ID_RECEIVER,
				new BigDecimal("200")
		);

		verify(accountRepository)
				.changeAmount(1, new BigDecimal(800));
		verify(accountRepository)
				.changeAmount(2, new BigDecimal(1200));
	}

}
