package com.anz.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.account.entity.TransactionsEntity;

public interface TransactionRepository extends JpaRepository<TransactionsEntity, String>{
	List<TransactionsEntity> findByAccountNo(long accountNo);
}
