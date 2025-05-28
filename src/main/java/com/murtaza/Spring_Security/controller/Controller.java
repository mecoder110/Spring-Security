package com.murtaza.Spring_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/public")
	public String publicEndpoint() {
		return "Public endpoint - no auth needed";
	}

	@GetMapping("/private")
	public String privateEndpoint() {
		return "Private endpoint - auth required";
	}

}
