package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.CreditCard;


public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

	public CreditCard findByNumber(String number);
	
}
