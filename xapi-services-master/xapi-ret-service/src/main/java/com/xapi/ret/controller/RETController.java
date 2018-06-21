package com.xapi.ret.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RETController {

	@RequestMapping(value = "/rate")
	public String getRate(@RequestParam(value = "ccyPair", defaultValue = "USD.SGD") String ccyPair) {
		log.info("Access /rate/{ccyPair} with ccyPair: {}", ccyPair);

		List<String> rates = Arrays.asList("1/1", "1.1/1.0", "2.1./2.2");
		Random rand = new Random();

		int randomNum = rand.nextInt(rates.size());
		return rates.get(randomNum);
	}

}
