package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.axh.snap.controllers.ActivityTemplate;

@Repository
public interface ActivityTemplateRepository extends MongoRepository<ActivityTemplate, String> {

}
