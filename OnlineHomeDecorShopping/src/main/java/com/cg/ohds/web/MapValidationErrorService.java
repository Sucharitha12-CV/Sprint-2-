package com.cg.ohds.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
/**
 * This class defines validation for the input given
 * @author Sucharitha
 *
 */
@Service
public class MapValidationErrorService {
	/**
	 * this method performs validation on given input
	 * @param result-defines an object of binding result
	 * @return response entity
	 */
	public ResponseEntity<?> mapValidationService(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap=new HashMap<>();
			for(FieldError fieldError:result.getFieldErrors()) {
				errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
				
			}
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
