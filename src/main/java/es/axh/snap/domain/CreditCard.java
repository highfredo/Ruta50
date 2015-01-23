package es.axh.snap.domain;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class CreditCard extends AbstractDocument {
	
	@CreditCardNumber
	private String number;
	private CardType cType; 
	private DateTime expirationDate;
	
	private String ownerName;
	private String hoseNumber;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	private String descripcion;
	
	
	public void setNumber(String number) {
		this.number = number;
		this.cType = CardType.detect(number);
	}
	

}
