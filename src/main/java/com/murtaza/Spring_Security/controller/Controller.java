package com.murtaza.Spring_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/public")
	public String publicEndpoint() {
		return "Public endpoint - no auth needed";
	}

	@GetMapping("/admin")
	public String adminEndpoint() {
		return "ADMIN endpoint - auth required";
	}
	
	@GetMapping("/user")
	public String userEndpoint() {
		return "USER endpoint - auth required";
	}

}
