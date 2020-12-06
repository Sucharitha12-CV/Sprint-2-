package com.cg.ohds.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * this class defines customer not found exception by extending runtime exception
 * @author Sucharitha
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception{
    /**
     * no parameter constructor
     */
	public CustomerNotFoundException() {
		super();
	}
    /**
     * parameterized constructor
     * @param message-the message that should be displayed when this exception is thrown
     */
	public CustomerNotFoundException(String message) {
		super(message);
	}
	

}
