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
import com.cg.ohds.entity.Cart;
import com.cg.ohds.entity.Customer;
import com.cg.ohds.entity.Product;
import com.cg.ohds.exception.CartNotFoundException;
import com.cg.ohds.repository.ICartRepository;
/**
 * this class tests the service layer of Cart
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCartServiceImpl {
	@MockBean
	private ICartRepository cartRepository;
	@Autowired
	private ICartService cartService;
	/**
	 * this method tests the method findByCartId in service layer of Cart
	 * @throws CartNotFoundException 
	 */
	@Test
	public void testGetCartById() throws CartNotFoundException{
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
	    Mockito.when(cartRepository.findByCartId(1)).thenReturn(cart);
	    assertThat(cartService.listCartById(1)).isEqualTo(cart);
	}
	/**
	 * this method tests the method updateCart in service layer of Cart
	 * @throws CartNotFoundException 
	 */
	@Test
	public void testUpdateCart() throws CartNotFoundException{
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		Mockito.when(cartRepository.findByCartId(1)).thenReturn(cart);
		Mockito.when(cartRepository.save(cart)).thenReturn(cart);
		assertThat(cartService.updateCart(cart)).isEqualTo(cart);		
	}
	/**
	 * this method tests the method listAllCarts in service layer of Cart
	 */
	@Test
	public void testListAllCarts() {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		Address address1=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer1=new Customer(2,"radha rani","radha1","dg!D5464","radha@gmail.com","9877565782",address1);
		Product product2=new Product(3,"Mats",900.0,12);
		Product product3=new Product(4,"Matress",955.0,11);
		List<Product> productList1=new ArrayList<>();
		productList1.add(product2);
		productList1.add(product3);
		Cart cart1=new Cart(2,customer1,productList1);
		List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        cartList.add(cart1);
        Mockito.when(cartRepository.findAll()).thenReturn(cartList);
        assertThat(cartService.listAllCarts()).isEqualTo(cartList);
	}
	/**
	 * this method tests the method saveCart in service layer of Cart
	 */
	@Test
	public void testSaveCart() {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		Mockito.when(cartRepository.save(cart)).thenReturn(cart);
		assertThat(cartService.saveCart(cart)).isEqualTo(cart);		
	}
	/**
	 * this method tests the method deleteCart in service layer of Cart
	 * @throws CartNotFoundException 
	 */
	@Test
    public void testDeleteCart() throws CartNotFoundException {
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		cartRepository.save(cart);
		Mockito.when(cartRepository.findByCartId(1)).thenReturn(cart);
		cartService.deleteCart(1);
		Assert.assertTrue(cartRepository.findById(1).isEmpty());
	}

}
