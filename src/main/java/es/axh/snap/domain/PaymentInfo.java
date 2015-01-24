package es.axh.snap.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class PaymentInfo extends AbstractDocument {

	private CreditCard creditCard;
	private Bundle bundle;
	private List<Route> routesTodo; 
	private Integer level;
	private Integer numberOfPeople;
	private JSONObject snapResponse;
	private Double amount;
		
}
