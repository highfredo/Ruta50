package es.axh.snap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.axh.snap.controllers.ActivityTemplate;
import es.axh.snap.domain.CreditCard;
import es.axh.snap.domain.PaymentInfo;
import es.axh.snap.repository.ActivityTemplateRepository;
import es.axh.snap.repository.CreditCardRepository;
import es.axh.snap.repository.PaymentInfoRepository;

@Service
public class PaymentService {
	
	@Autowired
	public CreditCardRepository creditCardRepository;
	@Autowired
	public PaymentInfoRepository paymentInfoRepository;
	@Autowired
	public ActivityTemplateRepository activityTemplateRepository;
	
	
	public PaymentInfo pay(String credictCardId, String activityId, Integer numberOfTickets) {
		PaymentInfo paymentInfo = new PaymentInfo();
		CreditCard creditCard = creditCardRepository.findOne(credictCardId);
		ActivityTemplate activity = activityTemplateRepository.findOne(activityId);
		
		//TODO: saltar error si no existe la tarjeta o la actividad
		
		paymentInfo.setAmount(activity.getAmount() * numberOfTickets);
		paymentInfo.setCreditCard(creditCard);
		paymentInfo.setCurrency("EUR");
		//TODO: paymentInfo.setConcepto(concepto);
		
		return paymentInfo;
	}
	
	public PaymentInfo getPayment(String paymentId) {
		return paymentInfoRepository.findOne(paymentId);
	}
	

}
