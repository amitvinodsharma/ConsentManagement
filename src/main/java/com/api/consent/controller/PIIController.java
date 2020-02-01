package com.api.consent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.consent.model.PII;
import com.api.consent.service.PIIService;

@RestController
public class PIIController {
	
	@Autowired
	PIIService piiService;
	
	@RequestMapping(value = "/piis", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PII> PIIs() {
		
		List<PII> listOfPIIs = piiService.getAllPIIs();
		return listOfPIIs;
	}

	@RequestMapping(value = "/piis/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public PII PIIById(@PathVariable int id) {
		PII pii = piiService.getPII(id);
		System.out.println(pii);
		return pii;
	}

	@RequestMapping(value = "/piis", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<PII> addPII(@RequestBody PII pII) {
		PII pii1 = piiService.addPII(pII);
		ResponseEntity<PII> response = new ResponseEntity<PII>(pii1, HttpStatus.CREATED);
		return response;
		
	}

	@RequestMapping(value = "/piis/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<PII> updatePII(@RequestBody PII pII) {
		PII  pii1 = piiService.updatePII(pII);
		ResponseEntity<PII> response = new ResponseEntity<PII>(pii1, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/piis/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePII(@PathVariable("id") int id) {
		piiService.deletePII(id);		
	}	
}
