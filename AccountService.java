package com.account.springboot.service;

import com.account.springboot.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	     
	  
	  public List<Account> getAllAccounts(){
		  
		try {  String sql = "SELECT * FROM account";
	         
	        List<Account> accounts = 
	        		jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Account.class));
	        System.out.print(accounts);
		  return accounts;
		}
		catch(EmptyResultDataAccessException e) {
			System.out.print("Empty");
			return null;
		}
		  
	  }


	public Account getAccount(String id) {
		 String sql = "SELECT * FROM account where AccountId=?";
         
			@SuppressWarnings("deprecation")
			Account accounts = jdbcTemplate.queryForObject(sql,new Object[] {id},
	                BeanPropertyRowMapper.newInstance(Account.class));
		  return accounts;
		 	}


	public void updateAccount(Account account,String id) {
		String updateQuery = "update account set AccountHolderName = ?,AccountBalance=? where AccountID = ?";
		
		jdbcTemplate.update(updateQuery, account.getAccountHolderName(),account.getAccountBalance(), id);

		}


	public void deleteAccount(String id) {
		String deleteQuery = "delete from account where AccountId = ?";
		
		jdbcTemplate.update(deleteQuery, id);

	}
	public void addAccount(Account account) {
		
		jdbcTemplate.update(
			    "INSERT INTO account (accountid, accountholdername,accountbalance,accountStatus)"
			    + " VALUES (?, ?, ?, ?)",
			    account.getAccountId(),account.getAccountHolderName(),account.getAccountBalance(),account.getAccountStatus());	}

}
