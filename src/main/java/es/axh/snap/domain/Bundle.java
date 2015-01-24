package es.axh.snap.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=true)
@Document
public class Bundle extends AbstractDocument{

	private String name;
	private String description;
	private String city;
	private List<Route> routes;
	private List<String> tags;
}
