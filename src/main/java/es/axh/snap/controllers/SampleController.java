package es.axh.snap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.axh.snap.domain.snap.AuthorizeAndCaptureTransaction;
import es.axh.snap.service.SnapService;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	private SnapService snapService;
	
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorizeAndCaptureTransaction sample() {
    	
    	snapService.pay(new AuthorizeAndCaptureTransaction());
    	
        return new AuthorizeAndCaptureTransaction();
    }


}
