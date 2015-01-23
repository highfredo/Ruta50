package es.axh.snap.domain;

import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonView;

@Data
@EqualsAndHashCode(callSuper=true)
public abstract class AbstractDocument extends AbstractAuditingEntity {

	public interface DocumentView {	}
	
	@Id @JsonView(DocumentView.class)
	private String id;
	
	@Version @JsonView(DocumentView.class)
	private Long version;
	
}