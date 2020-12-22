package com.cg.ohds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * this class defines the details of the customer 
 * @author Sucharitha
 *
 */

@Entity(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	@ApiModelProperty(notes="auto generated id of customer")
	private int customerId;
	@Column(name="customer_name")
	@NotBlank(message="name should be given")
	@ApiModelProperty(notes="name of customer")
	private String customerName;
	@Column(name="customer_user_name")
	@NotBlank(message="user name should be given")
	@ApiModelProperty(notes="user name of customer")
	private String customerUserName;
	@Column(name="cutomer_password")
	@NotBlank(message="password should be given")
	@ApiModelProperty(notes="password of customer")
	@Size(min=8,max=20)
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String customerPassword;
	@Column(name="customer_email")
	@NotBlank(message="email should be given")
	@ApiModelProperty(notes="email of customer")
	@Pattern(regexp="[a-zA-Z0-9+_.-]{5,15}[@][a-zA-Z]{1,8}[.][a-z]{2,5}")
	private String customerEmail;
	@Column(name="customer_phone_No")
	@NotBlank(message="phone number should be given")
	@ApiModelProperty(notes="phone number of customer")
	@Pattern(regexp="[6-9]{1}[0-9]{9}")
	private String customerPhoneNo;
	@NotBlank(message="address should be given")
	@ApiModelProperty(notes="address of customer")
	private String customerAddress;
	/**
	 * no parameter customer constructor
	 */
	public Customer() {
		super();
	}
	/**
	 * this is a parameterized constructor for customer 
	 * @param customerId-defines id of a customer
	 * @param customerName-defines name of a customer
	 * @param customerUserName-defines user name of a customer
	 * @param customerPassword-defines password of a customer
	 * @param customerEmail-defines email of a customer
	 * @param customerPhoneNo-defines phone number of a customer
	 * @param customerAddress-defines address of a customer
	 */
	public Customer(int customerId, String customerName, String customerUserName, String customerPassword, String customerEmail, String customerPhoneNo,String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerAddress = customerAddress;
	}
	/**
	 * this method gives id of customer
	 * @return customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * this method sets id of customer
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * this method gives name of customer
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * this method sets name of a customer
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * this method gives username of customer
	 * @return customerUserName
	 */
	public String getCustomerUserName() {
		return customerUserName;
	}
	/**
	 * this method sets username of a customer
	 * @param customerUserName
	 */
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	/**
	 * this method gives password of customer
	 * @return customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}
	/**
	 * this method sets password of a customer
	 * @param customerPassword
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	/**
	 * this method gives email of customer
	 * @return customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * this method sets email of a customer
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * this method gives phone number of customer
	 * @return customerPhoneNo
	 */
	public @NotBlank(message = "phone number should be given") String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	/**
	 * this method sets phone number of a customer
	 * @param customerPhoneNo
	 */
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	/**
	 * this method gives address of customer
	 * @return customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * this method sets address of a customer
	 * @param customerAddress
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
}
