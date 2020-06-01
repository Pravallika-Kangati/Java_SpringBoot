package com.anz.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.anz.account.entity.AccountsEntity;


public class Accounts {

	private long accountNo;
	private String accountName;
	private String accountType;
	private LocalDate balanceDate;
	private String currency;
	private BigDecimal openingAvailableBalance;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public Accounts() {
		super();
	}

	// Converts Entity into model
	public static Accounts preapreEntityToModel(AccountsEntity accountEntity) 
	{
		Accounts account= new Accounts();
		account.setAccountNo(accountEntity.getAccountNo());
		account.setAccountName(accountEntity.getAccountName());
		account.setAccountType(accountEntity.getAccountType());
		account.setBalanceDate(accountEntity.getBalanceDate());
		account.setCurrency(accountEntity.getCurrency());
		account.setOpeningAvailableBalance(accountEntity.getOpeningAvailableBalance());
		return account;
	}
	
}

