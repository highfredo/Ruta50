package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.Authority;

/**
 * Spring Data MongoDB repository for the Authority entity.
 */
public interface AuthorityRepository extends MongoRepository<Authority, String> {
}
