package es.axh.snap.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
@EqualsAndHashCode(callSuper=false)
public class Route implements Comparable<Route>{

	private @TextIndexed String name;
	private @TextIndexed String description;
	private Double price;
	private String photo;
	
	@Override
	public int compareTo(Route o) {
		int res = this.getPrice().compareTo(o.getPrice());
		
		if(res == 0){
			res = this.getPhoto().compareTo(o.getPhoto());
		}
		
		return res;
	}
	
}
