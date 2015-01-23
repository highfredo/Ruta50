package es.axh.snap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	/*
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="payment/creditCard", method = RequestMethod.POST)
	public CreditCard save(CreditCard creditCard) {
		CreditCard resultCreditCard = paymentService.saveCreditCard(creditCard);
		
		return resultCreditCard;
	}
	*/
}
