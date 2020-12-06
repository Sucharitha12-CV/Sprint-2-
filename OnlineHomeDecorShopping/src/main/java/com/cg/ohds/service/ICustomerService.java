package com.cg.ohds.service;

import org.springframework.stereotype.Service;

import com.cg.ohds.entity.Customer;
import com.cg.ohds.exception.CustomerNotFoundException;
/**
 * this interface performs operations on customer
 * @author Sucharitha
 *
 */

@Service
public interface ICustomerService {
	//adds a new customer
	public Customer saveCustomer(Customer customer);
	//deletes a customer
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
	//updates a customer
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	//shows list of all customer present in data base
	public Iterable<Customer> listAllCustomers();
	//shows a customer who has given id
	public Customer listCustomerById(int customerId)throws CustomerNotFoundException;
}
