package es.axh.snap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.axh.snap.controllers.dto.PayDTO;
import es.axh.snap.domain.CreditCard;
import es.axh.snap.domain.PaymentInfo;
import es.axh.snap.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentResource {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentInfo pay(@RequestBody PayDTO payDto) {
		
        return paymentService.pay(payDto.getCreditCard(), payDto.getBundleId(), payDto.getMaxPrecio(), payDto.getNumberOfPeople());
    }

}
