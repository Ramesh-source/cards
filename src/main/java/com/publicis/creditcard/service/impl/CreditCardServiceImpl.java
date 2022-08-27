package com.publicis.creditcard.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.publicis.creditcard.Exceptions.InvalidCardException;
import com.publicis.creditcard.Exceptions.NotFoundException;
import com.publicis.creditcard.dto.CreditCardDTO;
import com.publicis.creditcard.entity.CreditCard;
import com.publicis.creditcard.mapper.CreditCardMapper;
import com.publicis.creditcard.repository.CreditCardRepository;
import com.publicis.creditcard.service.CreditCardService;
import com.publicis.creditcard.utilities.CreditCardConstants;
import com.publicis.creditcard.utilities.ResponseDTO;
import com.publicis.creditcard.utilities.StatusEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

	private final CreditCardMapper creditCardMapper;
	private final CreditCardRepository creditCardRepo;

	@Override
	public ResponseDTO<List<CreditCardDTO>> addCreditCard(CreditCardDTO creditCardDTO) throws InvalidCardException {
		log.info("<<<<<<addCard CreditCardServiceImpl >>>>>>");
		if (creditCardDTO.getCardNumber() != null && validateCreditCard(creditCardDTO.getCardNumber())) {
			CreditCard creditCard = creditCardMapper.creditCardDTOToCreditCard(creditCardDTO);
			creditCardRepo.save(creditCard);
			List<CreditCard> ccList = creditCardRepo.findAll();
			List<CreditCardDTO> newCCList = creditCardMapper.creditCardToCreditCardDTOs(ccList);
			return new ResponseDTO<List<CreditCardDTO>>(newCCList, StatusEnum.SUCCESS,
					CreditCardConstants.SUCCESS_CODE);
		} else {
			throw new InvalidCardException();
		}

	}

	private boolean validateCreditCard(String cardNo) {
		if (cardNo.length() > 19) {
			return false;
		}
		int nDigits = cardNo.length();
		int nSum = 0;
		boolean isSecond = false;
		for (int i = nDigits - 1; i >= 0; i--) {
			int d = cardNo.charAt(i) - '0';
			if (isSecond == true)
				d = d * 2;
			// We add two digits to handle
			// cases that make two digits
			// after doubling
			nSum += d / 10;
			nSum += d % 10;
			isSecond = !isSecond;
		}
		return (nSum % 10 == 0);
	}

	@Override
	public ResponseDTO<List<CreditCardDTO>> getAllCards() throws NotFoundException {
		log.info("<<<<<<getAllCards CreditCardServiceImpl >>>>>>");
		List<CreditCardDTO> newCCList = null;
		List<CreditCard> ccList = creditCardRepo.findAll();
		newCCList = creditCardMapper.creditCardToCreditCardDTOs(ccList);
		if (newCCList != null && newCCList.size() > 0) {
			return new ResponseDTO<List<CreditCardDTO>>(newCCList, StatusEnum.SUCCESS,
					CreditCardConstants.SUCCESS_CODE);
		} else {
			throw new NotFoundException();
		}
	}
}
