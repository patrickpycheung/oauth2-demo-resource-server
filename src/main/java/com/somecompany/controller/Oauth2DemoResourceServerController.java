package com.somecompany.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class Oauth2DemoResourceServerController {

	@GetMapping("/hello")
	@CrossOrigin
	public String api() {
		return "Made it to protected api on resource server!";
	}
}
