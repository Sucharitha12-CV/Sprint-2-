package com.cg.ohds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ohds.entity.Customer;
import com.cg.ohds.exception.CustomerNotFoundException;
import com.cg.ohds.repository.ICustomerRepository;
/**
 * this class performs operations on customer by implementing customer service interface
 * @author Sucharitha
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository customerRepository;
	/**
	 * this method adds a customer to database
	 * @param customer-customer which we want to add
	 * @return customer
	 */
	
	public Customer saveCustomer(Customer customer) {		
		return customerRepository.save(customer);
	}	
	/**
	 * this method deletes a customer from database
	 * @param customerId-id of customer to be deleted
	 * @throws CustomerNotFoundException
	 */	
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException{
		Customer customer=customerRepository.findByCustomerId(customerId);
		try {
		    if(customer==null)
			    throw new CustomerNotFoundException("Customer with given id is not found");
		    else {
		        customerRepository.deleteById(customerId);
		        return true;
		    }
		}
		catch(CustomerNotFoundException ex) {
			return false;
		}
	}
	/**
	 * this method updates a customer to database		
	 * @param customer-customer to be updated
	 * @return customer
	 * @throws CustomerNotFoundException 
	 */		
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Customer updatedCustomer=customerRepository.findByCustomerId(customer.getCustomerId());
		try {
		if(updatedCustomer==null)
			throw new CustomerNotFoundException("Customer with given id is not found");
		else
			return customerRepository.save(customer);
		}
		catch(CustomerNotFoundException ex) {
			return null;
		}
	}
	/**
     * this method shows all customers present in the database
     * @return list of customers
     */
	public Iterable<Customer> listAllCustomers(){
		return customerRepository.findAll(); 
	}
	/**
	 * this method shows customer which has given id
	 * @param customerId-id of customer to be shown
	 * @return customer
	 * @throws CustomerNotFoundException
	 */			
	public Customer listCustomerById(int customerId) throws CustomerNotFoundException{  	
		Customer customer=customerRepository.findByCustomerId(customerId);
		try {
		    if(customer==null)
			    throw new CustomerNotFoundException("Customer with id is not found");
		    else
		    	return customer;
		}
		catch(CustomerNotFoundException ex) {
			return null;
		}
	}


}
