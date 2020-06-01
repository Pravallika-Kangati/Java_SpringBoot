package com.anz.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.account.entity.AccountsEntity;

public interface AccountRepository extends JpaRepository<AccountsEntity, String>{
	
}
