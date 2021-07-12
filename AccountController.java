package com.account.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.account.springboot.model.Account;
import com.account.springboot.model.Customer;
import com.account.springboot.service.AccountService;
import com.account.springboot.service.CustomerService;

@RestController
@RequestMapping("/api")
public class AccountController {	

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
		
	}
	@RequestMapping(method=RequestMethod.GET, value="/accounts/{id}")
	public Account getAccount( @PathVariable("id") String id){
		return accountService.getAccount(id);
	}	
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}")
	public void updateAccount(@RequestBody Account account,@PathVariable("id") String id){
		accountService.updateAccount(account,id);
		
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
	public void updateAccount(@PathVariable("id") String id){
		accountService.deleteAccount(id);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/accounts")

	public void addAccount(@RequestBody Account account){
		accountService.addAccount(account);
		
	}
}
