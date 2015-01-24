package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class CardData {
	@JsonProperty("CardType")
	private String cardType = "MasterCard";
	@JsonProperty("CardholderName")
	private String cardholderName = "John Doe";
	@JsonProperty("PAN")
	private String pan = "5454545454545454";
	@JsonProperty("Expire")
	private String expire = "1215";
}