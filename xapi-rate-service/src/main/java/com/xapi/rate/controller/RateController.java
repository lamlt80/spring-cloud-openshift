package com.xapi.rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xapi.rate.service.RateService;

@RestController
public class RateController {

	@Autowired
	private RateService rateService;

	@GetMapping("/")
	public ResponseEntity<String> getRates(@RequestParam(value = "ccyPair", defaultValue = "USD.SGD") String ccyPair) {
		String rate = String.format("Return rate: %s!", this.rateService.getRates(ccyPair));
		return ResponseEntity.ok(rate);
	}

}
