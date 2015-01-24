package es.axh.snap.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import es.axh.snap.controllers.ActivityTemplate;
import es.axh.snap.domain.Bundle;
import es.axh.snap.domain.CreditCard;
import es.axh.snap.domain.PaymentInfo;
import es.axh.snap.domain.Route;
import es.axh.snap.domain.snap.AuthorizeAndCaptureTransaction;
import es.axh.snap.repository.ActivityTemplateRepository;
import es.axh.snap.repository.BundleRepository;
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
	@Autowired
	public BundleRepository bundleRepository;
	@Autowired
	public SnapService snapService;
	@Autowired
	public BundleService bundleService;
	
	
	public PaymentInfo pay(CreditCard creditCard, String bundleId, Integer level, Integer numberOfPeople) {
		Bundle bundle = bundleRepository.findOne(bundleId);
		
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setCreditCard(creditCard);
		paymentInfo.setBundle(bundle);
		paymentInfo.setLevel(level);
		paymentInfo.setNumberOfPeople(numberOfPeople);
		
		AuthorizeAndCaptureTransaction authorizeAndCaptureTransaction = new AuthorizeAndCaptureTransaction();
		JSONObject snapResponse = snapService.pay(authorizeAndCaptureTransaction);
		
		paymentInfo.setSnapResponse(snapResponse);
				
		List<Route> rutas = bundleService.routesByBundleNumber(bundleId, level);
		paymentInfo.setRoutesTodo(rutas);
		
		Integer i = rutas.size()-1 < 0 ? rutas.size()-1 : 0;
		paymentInfo.setAmount(rutas.get(i).getPrice() * numberOfPeople);
				
		return paymentInfo;
	}
	
	
	public PaymentInfo getPayment(String paymentId) {
		return paymentInfoRepository.findOne(paymentId);
	}

	

}
