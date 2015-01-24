package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class TenderData {

	@JsonProperty("CardData")
	private CardData cardata = new CardData();
	@JsonProperty("CardSecurityData")
	private CardSecurityData cardSecurityData = new CardSecurityData();

}
