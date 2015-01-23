package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.axh.snap.domain.PaymentInfo;

@Repository
public interface PaymentInfoRepository extends MongoRepository<PaymentInfo, String> {

}
