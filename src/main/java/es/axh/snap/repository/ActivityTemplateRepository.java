package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.controllers.ActivityTemplate;

public interface ActivityTemplateRepository extends MongoRepository<ActivityTemplate, String> {

}
