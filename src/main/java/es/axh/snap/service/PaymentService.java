package es.axh.snap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import es.axh.snap.controllers.ActivityTemplate;
import es.axh.snap.domain.CreditCard;
import es.axh.snap.domain.PaymentInfo;
import es.axh.snap.repository.ActivityTemplateRepository;
import es.axh.snap.repository.CreditCardRepository;
import es.axh.snap.repository.PaymentInfoRepository;
import es.axh.snap.security.SecurityUtils;

@Service
public class PaymentService {
	
	@Autowired
	public CreditCardRepository creditCardRepository;
	@Autowired
	public PaymentInfoRepository paymentInfoRepository;
	@Autowired
	public ActivityTemplateRepository activityTemplateRepository;
	
	public CreditCard saveCreditCard(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);		
	}
	
	public CreditCard getCreditCard(String creditCardId) {
		CreditCard creditCard = creditCardRepository.findOne(creditCardId);
		
		if(creditCard == null) return creditCard;
		
		if(!creditCard.getCreatedBy().equals(SecurityUtils.getCurrentLogin()))
			throw new AccessDeniedException("No tienes permisos para ver esa tarjeta de credito.");
		
		return creditCardRepository.findOne(creditCardId);
	}
	
	public void deleteCreditCard(String creditCardId) {
		creditCardRepository.delete(creditCardId);
	}
	
	public List<CreditCard> listCreditCard() {
		return creditCardRepository.findByCreatedBy(SecurityUtils.getCurrentLogin());
	}
	
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
