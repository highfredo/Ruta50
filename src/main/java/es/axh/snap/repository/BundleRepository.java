package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.Bundle;

public interface BundleRepository extends MongoRepository<Bundle, String> {
	
}
