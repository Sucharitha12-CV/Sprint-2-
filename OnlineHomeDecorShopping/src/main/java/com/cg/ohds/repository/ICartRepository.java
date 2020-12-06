package com.cg.ohds.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ohds.entity.Cart;
/**
 * this interface defines the operations performed on Cart and extends Jpa repository
 * @author Sucharitha
 *
 */
@Repository
public interface ICartRepository extends CrudRepository<Cart,Integer>{
	public Cart findByCartId(int cartId);

}
