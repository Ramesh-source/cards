package com.publicis.creditcard.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer creditCardID;
	private String name;
	private String cardNumber;
	private String balance = "0";
	private String limit;

}
