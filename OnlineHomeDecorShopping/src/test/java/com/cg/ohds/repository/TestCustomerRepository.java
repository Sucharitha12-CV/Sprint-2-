package com.cg.ohds.repository;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ohds.entity.Address;
import com.cg.ohds.entity.Customer;
/**
 * this class tests the Customer Repository Interface
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCustomerRepository {
	@Autowired
	private ICustomerRepository customerRepository;
	/**
	 * this method tests the find by customer id method 
	 * @throws Exception
	 */
	@Test
	public void testFindByCustomerId() throws Exception{
		
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		customerRepository.save(customer);
		Assert.assertNotNull(customerRepository.findByCustomerId(1));
	}

}
