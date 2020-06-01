package com.anz.account.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.model.Transactions;
import com.anz.account.exception.AccountsListException;
import com.anz.account.exception.TransactionsException;
import com.anz.account.model.Accounts;
import com.anz.account.service.AccountService;

@RestController
@Validated
@RequestMapping("/AccountHolders")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//Fetching Accounts List Of AccountHolders
	@GetMapping("/accountsList")
	public  List<Accounts> fetchAccountsList() throws AccountsListException{
		return accountService.fetchAccountsList();
	}
	
	@GetMapping("/transactionsList/{accountNo}")
	public  List<Transactions> fetchByAccountNo(@PathVariable("accountNo") @NotBlank(message="Account Number should be not blank") @Size( min=10,message="Length should be 10") Integer accountNo) throws TransactionsException{
		return accountService.fetchByAccountNo(accountNo);
	}

}

