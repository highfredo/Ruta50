package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AuthorizeAndCaptureTransaction {

	@JsonProperty("$type")
	private String type = "AuthorizeAndCaptureTransaction,http://schemas.evosnap.com/CWS/v2.0/Transactions/Rest";
	@JsonProperty("Transaction")
	private Transaction transaction = new Transaction();
	@JsonProperty("ApplicationProfileId")
	private String applicationProfileId = "72446";
	@JsonProperty("MerchantProfileId")
	private String merchantProfileId = "SNAP_00004"; 
	
}

