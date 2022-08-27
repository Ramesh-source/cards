package com.publicis.creditcard.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CREDITCARD_ID")
	private Integer creditCardID;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardNumber;

	@Column(name = "BALANCE")
	private String balance;

	@Column(name = "`LIMIT`")
	private String limit;

	@Override
	public String toString() {
		return "CreditCard [creditCardID=" + creditCardID + ", name=" + name + ", cardNumber=" + cardNumber
				+ ", balance=" + balance + ", limit=" + limit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(creditCardID, other.creditCardID) && Objects.equals(limit, other.limit)
				&& Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cardNumber, creditCardID, limit, name);
	}

}
