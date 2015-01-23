package es.axh.snap.controllers;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.mapping.Document;

import es.axh.snap.domain.AbstractDocument;
import es.axh.snap.domain.ActivityTicket;
import es.axh.snap.domain.CreditCard;
import es.axh.snap.domain.PaymentInfo;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class ActivityTemplate extends AbstractDocument {

	public Double amount;
	public String descripcion;
	public String titulo;
	
}
