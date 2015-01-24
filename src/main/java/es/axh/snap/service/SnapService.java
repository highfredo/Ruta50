package es.axh.snap.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import es.axh.snap.domain.snap.AuthorizeAndCaptureTransaction;

@Service
public class SnapService {
	
	public static final String LOGIN_URL = "https://api.cipcert.goevo.com/REST/2.0.22/SvcInfo/token";
	public static final String PAY_URL = "https://api.cipcert.goevo.com/REST/2.0.22/Txn/DF83D00001";
	public static final String IdentityTokenEncoded = 
			"UEhOaGJXdzZRWE56WlhKMGFXOXVJRTFoYW05eVZtVnljMmx2YmowaU1TSWdUV2x1YjNKV1pYSnphVzl1UFNJeElpQkJjM05sY25ScGIyNUpSRDBpWHpkbU1qVXpOalV4TFRNNFlUTXRORFJqTlMwNFkyVTFMV00yTmpsbVpXUmxNREEwWkNJZ1NYTnpkV1Z5UFNKSmNHTkJkWFJvWlc1MGFXTmhkR2x2YmlJZ1NYTnpkV1ZKYm5OMFlXNTBQU0l5TURFMUxUQXhMVEUxVkRBMk9qQTVPak01TGpFMU5Wb2lJSGh0Ykc1ek9uTmhiV3c5SW5WeWJqcHZZWE5wY3pwdVlXMWxjenAwWXpwVFFVMU1PakV1TURwaGMzTmxjblJwYjI0aVBqeHpZVzFzT2tOdmJtUnBkR2x2Ym5NZ1RtOTBRbVZtYjNKbFBTSXlNREUxTFRBeExURTFWREEyT2pBNU9qTTVMakUxTlZvaUlFNXZkRTl1VDNKQlpuUmxjajBpTWpBeE9DMHdNUzB4TlZRd05qb3dPVG96T1M0eE5UVmFJajQ4TDNOaGJXdzZRMjl1WkdsMGFXOXVjejQ4YzJGdGJEcEJaSFpwWTJVK1BDOXpZVzFzT2tGa2RtbGpaVDQ4YzJGdGJEcEJkSFJ5YVdKMWRHVlRkR0YwWlcxbGJuUStQSE5oYld3NlUzVmlhbVZqZEQ0OGMyRnRiRHBPWVcxbFNXUmxiblJwWm1sbGNqNUJRVFpHUXpZNVF6UkVSakF3TURBeFBDOXpZVzFzT2s1aGJXVkpaR1Z1ZEdsbWFXVnlQand2YzJGdGJEcFRkV0pxWldOMFBqeHpZVzFzT2tGMGRISnBZblYwWlNCQmRIUnlhV0oxZEdWT1lXMWxQU0pUUVVzaUlFRjBkSEpwWW5WMFpVNWhiV1Z6Y0dGalpUMGlhSFIwY0RvdkwzTmphR1Z0WVhNdWFYQmpiMjF0WlhKalpTNWpiMjB2U1dSbGJuUnBkSGtpUGp4ellXMXNPa0YwZEhKcFluVjBaVlpoYkhWbFBrRkJOa1pETmpsRE5FUkdNREF3TURFOEwzTmhiV3c2UVhSMGNtbGlkWFJsVm1Gc2RXVStQQzl6WVcxc09rRjBkSEpwWW5WMFpUNDhjMkZ0YkRwQmRIUnlhV0oxZEdVZ1FYUjBjbWxpZFhSbFRtRnRaVDBpVTJWeWFXRnNJaUJCZEhSeWFXSjFkR1ZPWVcxbGMzQmhZMlU5SW1oMGRIQTZMeTl6WTJobGJXRnpMbWx3WTI5dGJXVnlZMlV1WTI5dEwwbGtaVzUwYVhSNUlqNDhjMkZ0YkRwQmRIUnlhV0oxZEdWV1lXeDFaVDQwTW1VMFpHWTFNaTA1TTJFNExUUTROek10T0Raa1pDMWhPRGt5Wmpkak9UUXhZalE4TDNOaGJXdzZRWFIwY21saWRYUmxWbUZzZFdVK1BDOXpZVzFzT2tGMGRISnBZblYwWlQ0OGMyRnRiRHBCZEhSeWFXSjFkR1VnUVhSMGNtbGlkWFJsVG1GdFpUMGlibUZ0WlNJZ1FYUjBjbWxpZFhSbFRtRnRaWE53WVdObFBTSm9kSFJ3T2k4dmMyTm9aVzFoY3k1NGJXeHpiMkZ3TG05eVp5OTNjeTh5TURBMUx6QTFMMmxrWlc1MGFYUjVMMk5zWVdsdGN5SStQSE5oYld3NlFYUjBjbWxpZFhSbFZtRnNkV1UrUVVFMlJrTTJPVU0wUkVZd01EQXdNVHd2YzJGdGJEcEJkSFJ5YVdKMWRHVldZV3gxWlQ0OEwzTmhiV3c2UVhSMGNtbGlkWFJsUGp3dmMyRnRiRHBCZEhSeWFXSjFkR1ZUZEdGMFpXMWxiblErUEZOcFoyNWhkSFZ5WlNCNGJXeHVjejBpYUhSMGNEb3ZMM2QzZHk1M015NXZjbWN2TWpBd01DOHdPUzk0Yld4a2MybG5JeUkrUEZOcFoyNWxaRWx1Wm04K1BFTmhibTl1YVdOaGJHbDZZWFJwYjI1TlpYUm9iMlFnUVd4bmIzSnBkR2h0UFNKb2RIUndPaTh2ZDNkM0xuY3pMbTl5Wnk4eU1EQXhMekV3TDNodGJDMWxlR010WXpFMGJpTWlQand2UTJGdWIyNXBZMkZzYVhwaGRHbHZiazFsZEdodlpENDhVMmxuYm1GMGRYSmxUV1YwYUc5a0lFRnNaMjl5YVhSb2JUMGlhSFIwY0RvdkwzZDNkeTUzTXk1dmNtY3ZNakF3TUM4d09TOTRiV3hrYzJsbkkzSnpZUzF6YUdFeElqNDhMMU5wWjI1aGRIVnlaVTFsZEdodlpENDhVbVZtWlhKbGJtTmxJRlZTU1QwaUkxODNaakkxTXpZMU1TMHpPR0V6TFRRMFl6VXRPR05sTlMxak5qWTVabVZrWlRBd05HUWlQanhVY21GdWMyWnZjbTF6UGp4VWNtRnVjMlp2Y20wZ1FXeG5iM0pwZEdodFBTSm9kSFJ3T2k4dmQzZDNMbmN6TG05eVp5OHlNREF3THpBNUwzaHRiR1J6YVdjalpXNTJaV3h2Y0dWa0xYTnBaMjVoZEhWeVpTSStQQzlVY21GdWMyWnZjbTArUEZSeVlXNXpabTl5YlNCQmJHZHZjbWwwYUcwOUltaDBkSEE2THk5M2QzY3Vkek11YjNKbkx6SXdNREV2TVRBdmVHMXNMV1Y0WXkxak1UUnVJeUkrUEM5VWNtRnVjMlp2Y20wK1BDOVVjbUZ1YzJadmNtMXpQanhFYVdkbGMzUk5aWFJvYjJRZ1FXeG5iM0pwZEdodFBTSm9kSFJ3T2k4dmQzZDNMbmN6TG05eVp5OHlNREF3THpBNUwzaHRiR1J6YVdjamMyaGhNU0krUEM5RWFXZGxjM1JOWlhSb2IyUStQRVJwWjJWemRGWmhiSFZsUGtFelJrcGxNVUYxTm5oVmRIZElSa0phT1hkQkwzbERWV2ROYnowOEwwUnBaMlZ6ZEZaaGJIVmxQand2VW1WbVpYSmxibU5sUGp3dlUybG5ibVZrU1c1bWJ6NDhVMmxuYm1GMGRYSmxWbUZzZFdVK1VrVlNjWGhzWlRFdlJqbEdUVk5sTmxkcVFXOWlUMWs0UmxsUWFVUm1PVUVyWmt3cmFrNTJNazFCV1hVcmFsaFFOVzlhVmpaNGRuVXdiR0poU0RkTFZraHBWR2Q1ZEZOWFRXVmFkREkxVkhCeU9IUldMMEZrYTFKc1ZrNVFUa1l3YjAxeE1FTlFOVFF5ZWxwMFFTOTRVVzkxY1ZCRFIyWm9lWGw1YjBaMk9IY3hiM2xoUkdkWmRHMTBSMGhQZWpGb04zRTVNVWxCVVVzelNIRmtTbTFXVWl0V05ITnFaRVY0T0RGSFVFdzFOV3RWZFdkRmNFSlhjSGd2VEUxTlFTdExXRkZFZVdOcVIyRXhRWGRGWlRKemEyVmpTRkpsV1dRNGRVMXBLelJOY1VNMk4yNUxNRFZsWkc1U2FWVjNXVGhoVW5aM1oxZDNXbGtyT1ZkbFlVRjBVMHh6UkU4NE9EVlBjM1k0Tkd0UFdrTjNURFptYlRGbFlVdEtkVWxDWlVOWUwxQXhaWFpVUWxGdVdFWlliREEzT1ZORWJIVTVha0oyZEZKbWEyTjNNVE51WnpBNGFqTnRNVFZSTVhNMFRuazRaRzFQV0dKM1BUMDhMMU5wWjI1aGRIVnlaVlpoYkhWbFBqeExaWGxKYm1adlBqeHZPbE5sWTNWeWFYUjVWRzlyWlc1U1pXWmxjbVZ1WTJVZ2VHMXNibk02YnowaWFIUjBjRG92TDJSdlkzTXViMkZ6YVhNdGIzQmxiaTV2Y21jdmQzTnpMekl3TURRdk1ERXZiMkZ6YVhNdE1qQXdOREF4TFhkemN5MTNjM05sWTNWeWFYUjVMWE5sWTJWNGRDMHhMakF1ZUhOa0lqNDhienBMWlhsSlpHVnVkR2xtYVdWeUlGWmhiSFZsVkhsd1pUMGlhSFIwY0RvdkwyUnZZM011YjJGemFYTXRiM0JsYmk1dmNtY3ZkM056TDI5aGMybHpMWGR6Y3kxemIyRndMVzFsYzNOaFoyVXRjMlZqZFhKcGRIa3RNUzR4STFSb2RXMWljSEpwYm5SVFNFRXhJajVpUWtjd1UwY3ZkMlJDTldKNGVWcHlZakV2YlRWTGFraExNVTA5UEM5dk9rdGxlVWxrWlc1MGFXWnBaWEkrUEM5dk9sTmxZM1Z5YVhSNVZHOXJaVzVTWldabGNtVnVZMlUrUEM5TFpYbEpibVp2UGp3dlUybG5ibUYwZFhKbFBqd3ZjMkZ0YkRwQmMzTmxjblJwYjI0Kzo=";

	
	@SuppressWarnings("rawtypes")
	public String login() {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + IdentityTokenEncoded);

		HttpEntity<?> entity = new HttpEntity(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(LOGIN_URL, HttpMethod.GET, entity, String.class);
		String result = response.getBody().replaceAll("\"", "");
		reverse
		return result;
	}
	
	public JSONObject pay(AuthorizeAndCaptureTransaction authorizeAndCaptureTransaction) {
		String sessionToken = this.login() + ":";  
		sessionToken = Base64.getEncoder().encodeToString(sessionToken.getBytes());
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Basic " + sessionToken);
				
		HttpEntity<AuthorizeAndCaptureTransaction> entity = 
				new HttpEntity<AuthorizeAndCaptureTransaction>(authorizeAndCaptureTransaction, headers);
		
		ResponseEntity<JSONObject> response = restTemplate.postForEntity(PAY_URL, entity, JSONObject.class);
						
		return response.getBody();
	}

}

/*
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);

HttpEntity<AuthorizeAndCaptureTransaction> entity = 
		new HttpEntity<AuthorizeAndCaptureTransaction>(authorizeAndCaptureTransaction, headers);
restTemplate.put(uRL, entity);
*/