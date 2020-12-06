package com.cg.ohds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ohds.entity.Cart;
import com.cg.ohds.exception.CartNotFoundException;
import com.cg.ohds.repository.ICartRepository;
/**
 * this class performs operations on cart by implementing cart service interface
 * @author Sucharitha
 *
 */
@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private ICartRepository cartRepository;
	/**
	 * this method adds a cart to database
	 * @param cart-cart which we want to add
	 * @return cart
	 */
	public Cart saveCart(Cart cart) {		
		return cartRepository.save(cart);
	}	
	/**
	 * this method deletes a cart from database
	 * @param cartId-id of cart to be deleted
	 * @throws CartNotFoundException 
	 */	
	public boolean deleteCart(int cartId) throws CartNotFoundException {
		try {
		    Cart cart=cartRepository.findByCartId(cartId);
		    if(cart==null)
			    throw new CartNotFoundException("Cart with given id is not found");
		    else {
		        cartRepository.deleteById(cartId);
		        return true;
		    }
		}
		catch(CartNotFoundException ex) {
			return false;
		}
	}
	/**
	 * this method updates a cart to database		
	 * @param cart-cart to be updated
	 * @return cart
	 * @throws CartNotFoundException 
	 */
	public Cart updateCart(Cart cart) throws CartNotFoundException { 
		Cart updatedCart=cartRepository.findByCartId(cart.getCartId());
		try {
		    if(updatedCart==null)
			    throw new CartNotFoundException("Cart with given id is not found");
		    else
			    return cartRepository.save(cart);
	   }
		catch(CartNotFoundException ex) {
			return null;
		}
	}
    /**
     * this method shows all carts present in the database
     * @return list of carts
     */
	public Iterable<Cart> listAllCarts(){
		return cartRepository.findAll(); 
	}
	/**
	 * this method shows cart which has given id
	 * @param cartId-id of cart to be shown
	 * @return cart
	 * @throws CartNotFoundException 
	 */
	public Cart listCartById(int cartId) throws CartNotFoundException{
		Cart cart=cartRepository.findByCartId(cartId);
		try {
		    if(cart==null)
			    throw new CartNotFoundException("Cart with id is not found");
		    else
			    return cart;
	    }
		catch(CartNotFoundException ex) {
			return null;
		}
		
	}


}
