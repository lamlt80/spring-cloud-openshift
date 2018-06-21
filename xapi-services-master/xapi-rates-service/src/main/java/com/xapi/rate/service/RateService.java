package com.xapi.rate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xapi.rate.RETServiceRibbonConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RibbonClient(name = "xapi-ret-service", configuration = RETServiceRibbonConfig.class)
public class RateService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackRate", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	})
	public String getRates(String ccyPair) {
		log.info("ccyPair: {}", ccyPair);
		return this.restTemplate.getForObject(String.format("http://xapi-gateway/ret/rate?ccyPair=%s!", ccyPair), String.class);
	}

	/**
	 * This fallback method will be called when connecting to xapi-ret-service is failed.
	 * @param ccyPair
	 * @return
	 */
	private String getFallbackRate(String ccyPair) {
		log.info("call getFallbackRate");
		
		String backupRate = "This is backup rate: 1.0/1.0";
		//TODO: acces to DB to get backup rate.
		
		return backupRate;
	}
}
