package com.cg.ohds.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ohds.entity.Address;
import com.cg.ohds.entity.Cart;
import com.cg.ohds.entity.Customer;
import com.cg.ohds.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
/**
 * this class tests the cart repository operations
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCartRepository {

	@Autowired
	private ICartRepository cartRepository;
	/**
	 * this method tests the find by cart id method
	 * @throws Exception
	 */
	@Test
	public void testFindByCartId() throws Exception{
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		cartRepository.save(cart);
		Assert.assertNotNull(cartRepository.findByCartId(1));
	}

}
