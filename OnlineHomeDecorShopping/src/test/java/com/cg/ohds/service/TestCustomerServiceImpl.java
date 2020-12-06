package com.cg.ohds.service;




import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ohds.entity.Address;
import com.cg.ohds.entity.Customer;
import com.cg.ohds.exception.CustomerNotFoundException;
import com.cg.ohds.repository.ICustomerRepository;
/**
 * this class tests the operations on customer in service layer
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerServiceImpl {
	@MockBean
	private ICustomerRepository customerRepository;
	@Autowired
	private ICustomerService customerService;
	/**
	 * this method tests the method findByCustomerId in service layer of Customer
	 * @throws CustomerNotFoundException 
	 */
	@Test
	public void testGetCustomerById() throws CustomerNotFoundException{
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Mockito.when(customerRepository.findByCustomerId(1)).thenReturn(customer);
	    assertThat(customerService.listCustomerById(1)).isEqualTo(customer);
	}
	/**
	 * this method tests the method updateCustomer in service layer of Customer
	 * @throws CustomerNotFoundException 
	 */
	@Test
	public void testUpdateCustomer() throws CustomerNotFoundException{
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Mockito.when(customerRepository.findByCustomerId(1)).thenReturn(customer);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.updateCustomer(customer)).isEqualTo(customer);		
	}
	/**
	 * this method tests the method listAllCustomers in service layer of Customer
	 */
	@Test
	public void testListAllCustomers() {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Address address1=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer1=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address1);
		List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        Mockito.when(customerRepository.findAll()).thenReturn(customerList);
        assertThat(customerService.listAllCustomers()).isEqualTo(customerList);
	}
	/**
	 * this method tests the method saveCustomer in service layer of Customer
	 */
	@Test
	public void testSaveCustomer() {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.saveCustomer(customer)).isEqualTo(customer);		
	}
	/**
	 * this method tests the method deleteCustomer in service layer of Customer
	 * @throws CustomerNotFoundException 
	 */
	@Test
    public void testDeleteCustomer() throws CustomerNotFoundException {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		customerRepository.save(customer);
		Mockito.when(customerRepository.findByCustomerId(2)).thenReturn(customer);
		customerService.deleteCustomer(2);
		Assert.assertTrue(customerRepository.findById(2).isEmpty());
	}



}
