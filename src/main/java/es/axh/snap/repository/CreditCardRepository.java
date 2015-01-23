package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.axh.snap.domain.CreditCard;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

	public CreditCard findByNumber(String number);
	
}
