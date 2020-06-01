package com.anz.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.anz.account.entity.TransactionsEntity;


public class Transactions {
	
	private int id;
	private Integer accountNo;
	private String accountName;
	private LocalDate valueDate;
	private String currency;
	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	private String debitORCredit;
	private String transactionNarrative;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDebitORCredit() {
		return debitORCredit;
	}

	public void setDebitORCredit(String debitORCredit) {
		this.debitORCredit = debitORCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	
	public Transactions() {
		super();
	}

	// Converts Entity into model
	public static Transactions prepareEntityToModel(TransactionsEntity transactionEntity) 
	{
		Transactions transaction = new Transactions();
		transaction.setAccountNo(transactionEntity.getAccountNo());
		transaction.setAccountName(transactionEntity.getAccountName());
		transaction.setDebitORCredit(transactionEntity.getDebitORCredit());
		transaction.setValueDate(transactionEntity.getValueDate());
		transaction.setCurrency(transactionEntity.getCurrency());
		transaction.setDebitAmount(transactionEntity.getDebitAmount());
		transaction.setCreditAmount(transactionEntity.getCreditAmount());
		transaction.setTransactionNarrative(transactionEntity.getTransactionNarrative());
		return transaction;
	}
	
}
