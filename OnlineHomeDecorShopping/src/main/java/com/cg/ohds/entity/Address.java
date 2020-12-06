package com.cg.ohds.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
/**
 * this class defines required address field of the user
 * @author Sucharitha
 *
 */
@Embeddable
public class Address {
	@Column(name="address_line")
    @NotBlank(message="address line should be given")
	@ApiModelProperty(notes="address line of customer")
	private String addressLine;
	@Column(name="city")
	@NotBlank(message="city should be given")
	@ApiModelProperty(notes="city of customer")
	private String city;
	@Column(name="state")
	@NotBlank(message="state should be given")
	@ApiModelProperty(notes="state of customer")
	private String state;
	@Column(name="country")
	@NotBlank(message="country should be given")
	@ApiModelProperty(notes="country of customer")
	private String country;
	@Column(name="pincode")
	@NotNull(message="pincode should be given")
	@ApiModelProperty(notes="pincode of customer")
	private int pincode;
	/**
	 * this is a parameterized constructor of address
	 * @param addressLine-defines address line of the user
	 * @param city-defines city of the user
	 * @param state-defines state of the user
	 * @param country-defines country of the user 
	 * @param pinCode-defines pincode of the user
	 */
	
	/**
	 * this is a no parameter constructor
	 */
	public Address() {
		super();
	}
	public Address(@NotBlank(message = "address line should be given") String addressLine,
			@NotBlank(message = "city should be given") String city,
			@NotBlank(message = "state should be given") String state,
			@NotBlank(message = "country should be given") String country,
			@NotNull(message = "pincode should be given") int pincode) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	/**
	 * this method gives the addressLine of user
	 * @return addressLine
	 */
	public String getAddressLine() {
		return addressLine;
	}
	/**
	 * this method sets the address line of user
	 * @param addressLine
	 */
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	/**
	 * this method gives the city of user
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * this method sets city of the user
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * this method gives the state of user
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * this method sets state of the user
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * this method gives the country of the user
	 * @return country
	 */
	
	public String getCountry() {
		return country;
	}
	/**
	 * this method sets country of the user
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * this method gives the pincode of the user
	 * @return pincode
	 */
	public int getPincode() {
		return pincode;
	}
	/**
	 * this method sets the pincode of the user
	 * @param pincode
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	

}
