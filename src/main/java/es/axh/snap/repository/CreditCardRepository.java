package es.axh.snap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.CreditCard;


public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

	public CreditCard findByNumber(String number);

	public List<CreditCard> findByCreatedBy(String currentLogin);
	
}
