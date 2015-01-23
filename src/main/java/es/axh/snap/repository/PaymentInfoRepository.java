package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.PaymentInfo;


public interface PaymentInfoRepository extends MongoRepository<PaymentInfo, String> {

}
