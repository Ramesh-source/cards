package com.publicis.creditcard.service;

import java.util.List;

import com.publicis.creditcard.Exceptions.InvalidCardException;
import com.publicis.creditcard.Exceptions.NotFoundException;
import com.publicis.creditcard.dto.CreditCardDTO;
import com.publicis.creditcard.utilities.ResponseDTO;

public interface CreditCardService {

	ResponseDTO<List<CreditCardDTO>> addCreditCard(CreditCardDTO creditCardDTO) throws InvalidCardException;

	ResponseDTO<List<CreditCardDTO>> getAllCards() throws NotFoundException;
}
