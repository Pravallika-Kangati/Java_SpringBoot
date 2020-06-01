package com.anz.account;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.account.entity.AccountsEntity;
import com.anz.account.entity.TransactionsEntity;
import com.anz.account.exception.AccountsListException;
import com.anz.account.exception.TransactionsException;
import com.anz.account.model.Accounts;
import com.anz.account.model.Transactions;
import com.anz.account.repository.AccountRepository;
import com.anz.account.repository.TransactionRepository;
import com.anz.account.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAccountService {
	
	@Mock
	private AccountRepository accountRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private AccountService accountservice;
	
	private List<AccountsEntity> accountsListMock = null;
	private List<TransactionsEntity> transactionsListMock = null;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAccountsListTest() throws AccountsListException {
		AccountsEntity accountEntity = new AccountsEntity();
		accountEntity.setAccountNo(123456789);
		accountEntity.setAccountName("Raja Laxmi");
		accountEntity.setAccountType("Current");
		accountEntity.setBalanceDate(LocalDate.of(2019, 03, 24));
		accountEntity.setCurrency("USD");
		accountEntity.setOpeningAvailableBalance(BigDecimal.valueOf(124567890.0987654321));
		accountsListMock = new ArrayList<>();
		accountsListMock.add(accountEntity);
		when(accountRepository.findAll()).thenReturn((List<AccountsEntity>) accountsListMock);
		List<Accounts> accountsList = accountservice.fetchAccountsList();
		assertEquals (1,accountsList.size());
	}
	
	@Test
	public void getTransactionsListTest() throws TransactionsException {
		TransactionsEntity transaction = new TransactionsEntity();
		transaction.setAccountNo(585309209);
		transaction.setAccountName("SGSavings726");
		transaction.setCreditAmount(BigDecimal.valueOf(8999.99));
		transaction.setCurrency("SGD");
		transaction.setDebitAmount(BigDecimal.valueOf(0.0));
		transaction.setTransactionNarrative(" ");
		transaction.setDebitORCredit("Credit");
		transaction.setValueDate(LocalDate.of(2012, 12, 01));
		transactionsListMock = new ArrayList<>();
		transactionsListMock.add(transaction);
		when(transactionRepository.findByAccountNo(585309209)).thenReturn((List<TransactionsEntity>) transactionsListMock);
		List<Transactions> transactionList = accountservice.fetchByAccountNo(585309209);
		assertEquals(1,transactionList.size());
	}
	
	@Test
	public void AccountsExceptionTest() {
		Exception exception = assertThrows(AccountsListException.class,()->{
			accountservice.fetchAccountsList();
		});
		String expectMessage = "No Accounts List found";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectMessage));
	}
	
	@Test
	public void TransactionsExceptionTest() {
		Exception exception = assertThrows(TransactionsException.class,()->{
			accountservice.fetchByAccountNo(585309209);
		});
		String expectMessage = "Transactions are not found for the given account number";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectMessage));
	}

}
