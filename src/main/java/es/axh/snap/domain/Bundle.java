package es.axh.snap.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class Bundle extends AbstractDocument{

	private @TextIndexed String name;
	private @TextIndexed String description;
	private @TextIndexed String city;
	private List<Route> routes;
//	private @TextIndexed List<String> tags;
	
}
