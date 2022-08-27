package com.publicis.creditcard.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.publicis.creditcard.dto.CreditCardDTO;
import com.publicis.creditcard.entity.CreditCard;

@Mapper(componentModel = "spring", uses = {})
public interface CreditCardMapper {
	
	CreditCard creditCardDTOToCreditCard(CreditCardDTO creditCardDTO);
	
	CreditCardDTO creditCardToCreditCardDTO(CreditCard creditCard);
	
	List<CreditCardDTO> creditCardToCreditCardDTOs(List<CreditCard> creditCard);

}
