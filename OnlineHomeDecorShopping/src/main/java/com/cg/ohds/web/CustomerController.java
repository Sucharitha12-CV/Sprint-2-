package com.cg.ohds.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ohds.entity.Customer;
import com.cg.ohds.exception.CustomerNotFoundException;
import com.cg.ohds.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * this class connects controller and produces output for operation on customer 
 * @author Sucharitha
 *
 */
@RestController
@RequestMapping("/Customer")
@Api(value="Operations on customers")
@CrossOrigin
public class CustomerController {
	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	ICustomerService customerService;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	/**
	 * this method adds customer to the database
	 * @param customer-object of customer 
	 * @param result-object of binding result
	 * @return customer and http status
	 */
	@ApiOperation(value="Adding a customer")
	@PostMapping("/customer")
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		logger.info("adding customer");
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			logger.warn("Hey! give correct details.");
			return errorMap;
		}
		Customer newCustomer=customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
		
	}
	/**
	 * this method deletes customer from data base
	 * @param customerId-id of customer
	 * @return string 
	 * @throws CustomerNotFoundException 
	 */
	@ApiOperation(value="Deleting a customer")
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException{		  
		logger.info("deleting customer with id: "+customerId);
		boolean b=customerService.deleteCustomer(customerId); 
	    if(b)
	        return new ResponseEntity<String>("Customer with Id : "+customerId+" Deleted!",HttpStatus.OK);
	    else
	    	throw new CustomerNotFoundException("Customer with given id is not found");
	}
	/**
	 * this method updates customer in to data base
	 * @param customerId-id of customer
	 * @param customer-customer object to be updated 
	 * @return string
	 * @throws CustomerNotFoundException 
	 */
	@ApiOperation(value="Updating a customer")
    @PutMapping("/customer/{customerId}")
	public ResponseEntity<String> update(@PathVariable int customerId, @RequestBody Customer customer) throws CustomerNotFoundException {
    	logger.info("updating customer with id: "+customerId);
    	Customer updateCustomer=customerService.updateCustomer(customer); 
	    if(updateCustomer!=null)
	        return new ResponseEntity<String>("Customer Updated!",HttpStatus.OK);
	    else
	    	throw new CustomerNotFoundException("Customer with given id is not found");
    }
    /**
     * this method shows the customer whose id is given
     * @param customerId-id of customer
     * @return customer object 
     * @throws CustomerNotFoundException 
     */
	@ApiOperation(value="getting a customer by id")
	@GetMapping("/show/{customerId}")
	public ResponseEntity<?> listByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException{
		logger.info("showing customer with id: "+customerId);
		Customer customer=customerService.listCustomerById(customerId);
		if(customer==null)
			throw new CustomerNotFoundException("Customer with given id is not found");
		else
		    return new ResponseEntity<Customer>(customerService.listCustomerById(customerId),HttpStatus.OK);
	}
	/**
	 * this method returns list of the customers
	 * @return list of cudtomers
	 */
	@ApiOperation(value="getting all customers")
	@GetMapping("/all")
	public Iterable<Customer> listAllCustomers(){
		logger.info("Listing all customers");
		return customerService.listAllCustomers();
	}
}
