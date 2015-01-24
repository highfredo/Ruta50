package es.axh.snap.domain.snap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TransactionData {

	@JsonProperty("$type")
	private String type = "BankcardTransactionDataPro,http://schemas.evosnap.com/CWS/v2.0/Transactions/Bankcard/Pro"; 
	
	@JsonProperty("CustomerPresent")
	private String customerPresent = "Ecommerce";
	
	@JsonProperty("EntryMode")
	private String entryMode = "Keyed";
	
	@JsonProperty("GoodsType")
	private String goodsType = "DigitalGoods";
	
	@JsonProperty("OrderNumber")
	private String orderNumber = "1234";
	
	@JsonProperty("SignatureCaptured")
	private Boolean signatureCaptured = false;
	
	@JsonProperty("Amount")
	private String amount = "10.00";
	
	@JsonProperty("CurrencyCode")
	private String currencyCode = "EUR";
	
	@JsonProperty("TransactionDateTime")
	private String transactionDateTime = "2015-01-15T22:41:11.478-07:00";
	
	@JsonProperty("PartialApprovalCapable")
	private String partialApprovalCapable = "NotSet";
	
	@JsonProperty("TransactionCode")
	private String transactionCode = "NotSet";
	
	@JsonProperty("Is3DSecure")
	private Boolean is3DSecure = false;
	
	@JsonProperty("CardholderAuthenticationEntity")
	private String cardholderAuthenticationEntity = "NotSet";
	
	@JsonProperty("CardPresence")
	private Boolean cardPresence = false;
	
}
