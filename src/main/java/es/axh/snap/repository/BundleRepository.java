package es.axh.snap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.Bundle;

public interface BundleRepository extends MongoRepository<Bundle, String> {
	
	public List<Bundle> search(String query);
	
	public Bundle create();
	
	public Bundle edit(String id);
}
