package com.anz.account.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(	AccountApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
