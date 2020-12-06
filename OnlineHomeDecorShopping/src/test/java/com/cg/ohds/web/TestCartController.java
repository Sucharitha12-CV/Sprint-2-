package com.cg.ohds.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ohds.entity.Address;
import com.cg.ohds.entity.Cart;
import com.cg.ohds.entity.Customer;
import com.cg.ohds.entity.Product;
import com.cg.ohds.repository.ICartRepository;
import com.cg.ohds.service.ICartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * this class tests the cart controller 
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class)
public class TestCartController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	ICartRepository cartRepository;
	@MockBean
	private ICartService cartService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * this method tests the save cart operation
	 * @throws Exception
	 */
	@Test
	public void testSaveCart() throws Exception{
	    String URI = "/Cart/cart";
	    Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
	    String jsonInput = this.converttoJson(cart);
	    Mockito.when(cartService.saveCart(Mockito.any(Cart.class))).thenReturn(cart);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the update cart operation
	 * @throws Exception
	 */
	@Test
	public void testUpdateCart() throws Exception {
		String URI = "/Cart/cart/{cartId}";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);     
        String jsonInput = this.converttoJson(cart);
        Mockito.when(cartService.updateCart(Mockito.any())).thenReturn(cart);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,1).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Cart Updated!");
	}
	/**
	 * this method tests the cart by id  operation on cart
	 * @throws Exception
	 */
	@Test
	public void testCartById() throws Exception {
		String URI= "/Cart/showCart/{cartId}";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
        String jsonInput = this.converttoJson(cart);
        Mockito.when(cartService.listCartById(1)).thenReturn(cart);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the list all carts operation
	 * @throws Exception
	 */
	@Test
	public void testGetAllCarts() throws Exception {
		String URI = "/Cart/allCarts";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Product product=new Product(1,"Mats",900.0,12);
		Product product1=new Product(2,"Matress",955.0,11);
		List<Product> productList=new ArrayList<>();
		productList.add(product);
		productList.add(product1);
		Cart cart=new Cart(1,customer,productList);
		Address address1=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer1=new Customer(2,"radha rani","radha1","dg!R5464","radha@gmail.com","9876543210",address1);
		Product product2=new Product(3,"Mats",900.0,12);
		Product product3=new Product(4,"Matress",955.0,11);
		List<Product> productList1=new ArrayList<>();
		productList1.add(product2);
		productList1.add(product3);
		Cart cart1=new Cart(2,customer1,productList1);
		List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        cartList.add(cart1);
	    String jsonInput = this.converttoJson(cartList);
        Mockito.when(cartService.listAllCarts()).thenReturn(cartList);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the delete cart operation
	 * @throws Exception
	 */
	@Test
	public void testDeleteCart() throws Exception {
		String URI = "/Cart/deleteCart/{cartId}";
		Mockito.when(cartService.deleteCart(1)).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Cart with Id : 1 Deleted!");
	}
	/**
	 * this method converts the given object to json format
	 * @param cart
	 * @return string
	 * @throws JsonProcessingException
	 */
	private String converttoJson(Object cart) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cart);
	}
}
