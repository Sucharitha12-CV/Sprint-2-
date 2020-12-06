package com.cg.ohds.service;

import org.springframework.stereotype.Service;

import com.cg.ohds.entity.Cart;
import com.cg.ohds.exception.CartNotFoundException;
/**
 * this interface performs operations on cart 
 * @author Sucharitha
 *
 */

@Service
public interface ICartService {
	//adds a new cart
	public Cart saveCart(Cart cart);
	//deletes a cart 
	public boolean deleteCart(int cartId) throws CartNotFoundException;
	//updates a cart
	public Cart updateCart(Cart cart) throws CartNotFoundException;
	//shows list of all carts present in data base
	public Iterable<Cart> listAllCarts();
	//shows a cart which has the given id
	public Cart listCartById(int cartId)throws CartNotFoundException;
}
