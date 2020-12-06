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
import com.cg.ohds.entity.Customer;
import com.cg.ohds.repository.ICustomerRepository;
import com.cg.ohds.service.ICustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * this class tests methods of customer controller class
 * @author Sucharitha
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class TestCustomerController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	ICustomerRepository customerRepository;
	@MockBean
	private ICustomerService customerService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * this method tests the save customer operation
	 * @throws Exception
	 */
	@Test
	public void testSaveCustomer() throws Exception{
	    String URI = "/Customer/customer";
	    Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
	    String jsonInput = this.converttoJson(customer);
	    Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn(customer);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the update customer operation
	 * @throws Exception
	 */
	@Test
	public void testUpdateCustomer() throws Exception {
		String URI = "/Customer/customer/{customerId}";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Mockito.when(customerService.updateCustomer(Mockito.any())).thenReturn(customer);
        String jsonInput = this.converttoJson(customerService.updateCustomer(customer));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,1).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        System.out.println(jsonOutput);
        assertThat(jsonOutput).isEqualTo("Customer Updated!");
	}
	/**
	 * this method tests the customer by id operation
	 * @throws Exception
	 */
	@Test
	public void testCustomerById() throws Exception {
		String URI= "/Customer/show/{customerId}";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
        String jsonInput = this.converttoJson(customer);
        Mockito.when(customerService.listCustomerById(1)).thenReturn(customer);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the lists all the customer operation
	 * @throws Exception
	 */
	@Test
	public void testGetAllCustomers() throws Exception {
		String URI = "/Customer/all";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Address address1=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer1=new Customer(2,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address1);
		List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
	    String jsonInput = this.converttoJson(customerList);
        Mockito.when(customerService.listAllCustomers()).thenReturn(customerList);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * this method tests the delete operation on customer
	 * @throws Exception
	 */
	@Test
	public void testDeleteCart() throws Exception {
		String URI = "/Customer/delete/{customerId}";
		Address address=new Address("1rt6","produttur","kadapa","India",12345);
		Customer customer=new Customer(1,"radha","radha1","dg!D5464","radha@gmail.com","9877565782",address);
		Mockito.when(customerRepository.findByCustomerId(1)).thenReturn(customer);
		Mockito.when(customerService.deleteCustomer(1)).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Customer with Id : 1 Deleted!");
	}
	/**
	 * this method converts given object data to json format
	 * @param customer
	 * @return string
	 * @throws JsonProcessingException
	 */
	private String converttoJson(Object customer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(customer);
	}

}
