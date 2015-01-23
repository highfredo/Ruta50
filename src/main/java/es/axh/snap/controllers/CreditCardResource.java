package es.axh.snap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.axh.snap.domain.CreditCard;
import es.axh.snap.service.PaymentService;

@RestController
@RequestMapping("/api")
public class CreditCardResource {

	// @RequestMapping("payment/creditCard/{credictCardId}") GET, POST, DELETE
	// @RequestMapping("payment/creditCard/list") GET
	// @RequestMapping("payment/pay/{paymentInfoId}") GET, POST
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="payment/creditCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCard> saveCreditCard(@RequestBody CreditCard creditCard) {
		CreditCard resultCreditCard = paymentService.saveCreditCard(creditCard);
		
		return new ResponseEntity<CreditCard>(resultCreditCard, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="payment/creditCard/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCard> getCreditCard(@PathVariable String cardId) {
		CreditCard resultCreditCard = paymentService.getCreditCard(cardId);
		
		if(resultCreditCard == null)
			return new ResponseEntity<CreditCard>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<CreditCard>(resultCreditCard, HttpStatus.OK);
	}
	
	@RequestMapping(value="payment/creditCard/{cardId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCreditCard(@PathVariable String cardId) {
		try {
			paymentService.deleteCreditCard(cardId);	
			return new ResponseEntity<String>("{\"result\": \"OK\"}", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("{\"result\": \"KO\"}", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="payment/creditCard/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CreditCard> listOwnCreditCard() {
		return paymentService.listCreditCard();
	}
	
}





