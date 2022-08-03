package com.msa.mainservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class TestController {
	
	@GetMapping("/test")
	public String test() throws Exception {
		log.info("--------------------- Test URL /test ------------------------------");
		return "test";
	}
}
