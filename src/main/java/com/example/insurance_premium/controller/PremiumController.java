package com.example.insurance_premium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurance_premium.entity.customerDTO;
import com.example.insurance_premium.service.PremiumService;

@RestController
@RequestMapping("/api/customer")
public class PremiumController {
	
	@Autowired
	private PremiumService premiumService;
	
	@GetMapping("/")
	public String premiumCalculator() {
		return "Welcome to Insurance Premium Calculator API";
	}
	@PostMapping("/getpremium")
	public double getPremium2(@RequestBody customerDTO customer ) {
		return premiumService.getPremium(customer);
	}
}
