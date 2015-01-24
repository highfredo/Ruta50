package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class InternationalAVSOverride {
	@JsonProperty("SkipAVS")
	private Boolean skipAVS = true;
}