package com.cg.ohds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * this class defines cart of a customer
 * @author Sucharitha
 *
 */

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> productList;
	/**
	 * this is a parameterized constructor of cart
	 * @param cartId-defines id of the cart
	 * @param customer-defines customer who owns the cart
	 * @param productList-defines the products present in the cart
	 */
	public Cart(int cartId, Customer customer, List<Product> productList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.productList = productList;
	}
	/**
	 * No parameter constructor
	 */
	public Cart() {
		super();
	}
	/**
	 * this method gives the id of the cart
	 * @return cartId
	 */
	public int getCartId() {
		return cartId;
	}
	/**
	 * this method sets the id of the cart
	 * @param cartId
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	/**
	 * this method gives the customer who owns the cart
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * this method sets the customer who owns the cart
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * this method gives the list of products present in the cart
	 * @return productList
	 */
	public List<Product> getProductList() {
		return productList;
	}
	/**
	 * this method sets the productList which should be present in cart
	 * @param productList
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
