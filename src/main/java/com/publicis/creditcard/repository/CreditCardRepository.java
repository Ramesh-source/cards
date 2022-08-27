package com.publicis.creditcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicis.creditcard.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
	
	List<CreditCard> findAll();
}
