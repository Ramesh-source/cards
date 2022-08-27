package com.publicis.creditcard.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.publicis.creditcard.utilities.CreditCardConstants;
import com.publicis.creditcard.utilities.CustomErrorResponse;

@ControllerAdvice
public class CreditCardExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> handleGenericNotFoundException(NotFoundException ex) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMsg(CreditCardConstants.NO_LIST_RETRIEVED_MSG);
		error.setErrorCode(CreditCardConstants.NO_LIST_RETRIEVED_CODE);
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler(value = InvalidCardException.class)
	public ResponseEntity<Object> handleGenericNotFoundException(InvalidCardException ex) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMsg(CreditCardConstants.NOT_VALID_CARD_MSG);
		error.setErrorCode(CreditCardConstants.NOT_VALID_CARD_CODE);
		return ResponseEntity.ok(error);
	}
}
