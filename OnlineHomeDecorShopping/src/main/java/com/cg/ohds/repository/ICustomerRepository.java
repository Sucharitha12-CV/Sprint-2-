package com.cg.ohds.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ohds.entity.Customer;
/**
 * this interface defines operations performed on customer and extends JPA repository
 * @author Sucharitha
 *
 */
@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Integer>{

	public Customer findByCustomerId(int customerId);

}
