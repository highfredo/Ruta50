package es.axh.snap.domain;

import org.springframework.data.mongodb.core.index.TextIndexed;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Route {

	private @TextIndexed String name;
	private @TextIndexed String description;
	private Double price;
	private String photo;
	
}
