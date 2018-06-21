package com.xapi.ret.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RETController {
	
	private final String hostName = System.getenv("HOSTNAME");
	
	@RequestMapping("/ret/host/name")
	public String getHostName() {
		Date date = new Date();
		log.info(String.format("Returning a name {} at time {}", this.hostName), date);
		return this.hostName +"-" + date;
	}

}
