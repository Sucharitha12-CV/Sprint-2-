package com.cg.ohds.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * this class defines cart not found exception by extending runtime exception
 * @author Sucharitha
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends Exception{
    /**
     * no parameter constructor
     */
	public CartNotFoundException() {
		super();
	}
	 /**
     * parameterized constructor
     * @param message-the message that should be displayed when this exception is thrown
     */
	public CartNotFoundException(String message) {
		super(message);
	}
}
