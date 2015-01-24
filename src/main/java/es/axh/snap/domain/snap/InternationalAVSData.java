package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class InternationalAVSData {
	@JsonProperty("HouseNumber")
	private String houseNumber = "123";
	@JsonProperty("Street")
	private String street = "Fake St";
	@JsonProperty("City")
	private String city = "Denver";
	@JsonProperty("StateProvince")
	private String stateProvince = "CO";
	@JsonProperty("PostalCode")
	private String postalCode = "80202";
	@JsonProperty("Country")
	private String country = "USA";
}