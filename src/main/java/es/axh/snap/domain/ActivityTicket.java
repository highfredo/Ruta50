package es.axh.snap.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.axh.snap.controllers.ActivityTemplate;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class ActivityTicket extends AbstractDocument {
	
	@DBRef
	private ActivityTemplate activityTemplate;
	
}
