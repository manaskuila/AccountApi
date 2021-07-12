package com.account.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.account.springboot.model.Account;
import com.account.springboot.model.Customer;

@Service
public class CustomerService {
	

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 
	  public List<Customer> getAllCustomers(){
		  
		try {  String sql = "SELECT * FROM customers";
	         
	        List<Customer> customer = 
	        		jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Customer.class));
	        System.out.print(customer);
		  return customer;
		}
		catch(EmptyResultDataAccessException e) {
			System.out.print("Empty");
			return null;
		}
		  
	  }




}
