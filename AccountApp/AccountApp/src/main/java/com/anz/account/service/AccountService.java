package com.anz.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.account.entity.TransactionsEntity;
import com.anz.account.exception.AccountsListException;
import com.anz.account.exception.TransactionsException;
import com.anz.account.entity.AccountsEntity;
import com.anz.account.model.Transactions;
import com.anz.account.model.Accounts;
import com.anz.account.repository.AccountRepository;
import com.anz.account.repository.TransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	public  List<Accounts> fetchAccountsList() throws AccountsListException
	{
		List<AccountsEntity> accountEntity =  accountRepository.findAll();
		List<Accounts> accountList = new ArrayList<Accounts>();
		if(accountEntity.isEmpty()) {
			throw new AccountsListException("No account List is Found");
		}
		for(AccountsEntity account : accountEntity)
		{
			accountList.add(Accounts.preapreEntityToModel(account));
		}
		return accountList;
	}
	
	public  List<Transactions> fetchByAccountNo(Integer accountNo) throws TransactionsException{
		List<TransactionsEntity> transactionEntity = transactionRepository.findByAccountNo(accountNo);
		List<Transactions> transactionList = new ArrayList<Transactions>();
		if(transactionEntity.isEmpty()) {
			throw new TransactionsException("Transactions are not found for the given Account Number");
		}else {
			for(TransactionsEntity transaction : transactionEntity)
			{
				transactionList.add(Transactions.prepareEntityToModel(transaction));
			}
			return transactionList;
		}
	}
}
