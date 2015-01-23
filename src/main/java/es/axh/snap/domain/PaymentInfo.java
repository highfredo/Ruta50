package es.axh.snap.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.axh.snap.controllers.ActivityTemplate;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class PaymentInfo extends AbstractDocument {

	// El numero de orden es la Id del documento
	private Double amount;
	private String currency;
	
	private CreditCard creditCard;
	
	private List<ActivityTicket> concepto; // TODO: pasar a objeto
	
}
