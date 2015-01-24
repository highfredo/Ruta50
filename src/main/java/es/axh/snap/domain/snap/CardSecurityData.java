package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class CardSecurityData {
	@JsonProperty("InternationalAVSData")
	private InternationalAVSData internationalAVSData = new InternationalAVSData();
	@JsonProperty("InternationalAVSOverride")
	private InternationalAVSOverride internationalAVSOverride = new InternationalAVSOverride();
	@JsonProperty("CVDataProvided")
	private String cvDataProvided = "Provided";
	@JsonProperty("CVData")
	private String cvData = "111";
}