package es.axh.snap.domain.snap;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Transaction {

	@JsonProperty("$type")
	private String type = "BankcardTransactionPro,http://schemas.evosnap.com/CWS/v2.0/Transactions/Bankcard/Pro";
	@JsonProperty("TenderData")
	private TenderData tenderData  = new TenderData();
	@JsonProperty("TransactionData")
	private TransactionData transactionData = new TransactionData();

}
