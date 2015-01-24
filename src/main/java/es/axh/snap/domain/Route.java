package es.axh.snap.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Route {

	private String description;
	private Double price;
	
}
