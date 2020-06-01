package com.anz.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.anz.account.controller.AccountController;
import com.anz.account.exception.AccountsListException;
import com.anz.account.exception.TransactionsException;
import com.anz.account.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=AccountController.class)
public class TestAccountController {
	
	@Autowired                           
    private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	//Test for fetching Accounts List
	@Test
	public void getAccountsList_thenReturnJsonArray()
	  throws AccountsListException { 
	    try {
			mockMvc.perform(get("/AccountHolders/accountsList")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test for fetching Transactions List
	@Test
	public void getAccountTransactionsList_thenReturnJsonArray()
	  throws TransactionsException { 
	    try {
			mockMvc.perform(get("/AccountHolders/transactionsList/585309209")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
