package com.cg.ohds.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ohds.entity.Cart;
import com.cg.ohds.exception.CartNotFoundException;
import com.cg.ohds.service.ICartService;
/**
 * this class connects controller and produces output for operation on cart 
 * @author Sucharitha
 *
 */
@RestController
@RequestMapping("/Cart")
public class CartController {
	private static final Logger logger=LoggerFactory.getLogger(CartController.class);
	@Autowired
	ICartService cartService;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	/**
	 * this method adds cart to the database
	 * @param cart-object of cart 
	 * @param result-object of binding result
	 * @return cart and http status
	 */
	@PostMapping("/cart")
	public ResponseEntity<?> saveCart(@Valid @RequestBody Cart cart, BindingResult result) {
		logger.info("adding cart");
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			logger.warn("Hey! give correct details.");
			return errorMap;
		}
		Cart newCart=cartService.saveCart(cart);
		return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		
	}
	/**
	 * this method deletes cart from data base
	 * @param cartId-id of cart
	 * @return string 
	 * @throws CartNotFoundException 
	 */
	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable int cartId) throws CartNotFoundException{		  
	    logger.info("deleting cart with id: "+cartId);
		boolean b=cartService.deleteCart(cartId); 
	    if(b)
	        return new ResponseEntity<String>("Cart with Id : "+cartId+" Deleted!",HttpStatus.OK);
	    else
	    	throw new CartNotFoundException("Cart with given id not found");
	  }
	/**
	 * this method updates cart in to data base
	 * @param cartId-id of customer
	 * @param cart-cart object to be updated 
	 * @return string
	 * @throws CartNotFoundException 
	 */
	@PutMapping("/cart/{cartId}")
	public ResponseEntity<String> update(@PathVariable int cartId,  @Valid @RequestBody Cart cart) throws CartNotFoundException {
		logger.info("updating cart with id: "+cart.getCartId());
		Cart updatedCart=cartService.updateCart(cart);
		System.out.println(updatedCart);
		if(updatedCart!=null)
	        return new ResponseEntity<String>("Cart Updated!",HttpStatus.OK);
		else
			throw new CartNotFoundException("Cart with given id not found");
	}
	/**
     * this method shows the cart whose id is given
     * @param cartId-id of cart
     * @return cart object 
	 * @throws CartNotFoundException 
     */
	@GetMapping("/showCart/{cartId}")
	public ResponseEntity<?> listByCartId(@PathVariable int cartId) throws CartNotFoundException{
		logger.info("showing cart with id: "+cartId);
		Cart cart=cartService.listCartById(cartId);
		if(cart!=null)
		    return new ResponseEntity<Cart>(cartService.listCartById(cartId),HttpStatus.OK);
		else
			throw new CartNotFoundException("Cart with given id not found");
	}
	/**
	 * this method returns list of the carts
	 * @return list of carts
	 */
	@GetMapping("/allCarts")
	public Iterable<Cart> listAllCarts(){
		logger.info("listing all the carts");
		return cartService.listAllCarts();
	}

}
