package es.axh.snap.controllers.dto;

import lombok.Data;
import es.axh.snap.domain.CreditCard;

@Data
public class PayDTO {
	
	private CreditCard creditCard;
	private String bundleId;
	private Double maxPrecio;
	private Integer numberOfPeople;

}
