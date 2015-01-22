package es.axh.snap.repository;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.PersistentAuditEvent;

/**
 * Spring Data MongoDB repository for the PersistentAuditEvent entity.
 */
public interface PersistenceAuditEventRepository extends MongoRepository<PersistentAuditEvent, String> {

    List<PersistentAuditEvent> findByPrincipal(String principal);

    List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfter(String principal, LocalDateTime after);

    List<PersistentAuditEvent> findAllByAuditEventDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
}
