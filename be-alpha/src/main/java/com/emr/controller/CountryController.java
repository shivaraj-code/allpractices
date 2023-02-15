package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Country;
import com.emr.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping("/hellocountry")
	public String venu() {
		return "Welcome to MY World..Country....";
	}

	@PostMapping("/country/add")
	public ResponseEntity<String> createCountry(@RequestBody Country countryrequest){
		Country cont=countryService.createCountry(countryrequest);
		return ResponseEntity.status(201).body("Country Records Created Successfully with Country Id"+cont.getCountry_id());
	}
	
	@GetMapping("/country/list")
	public List<Country> getCountry(){
		return countryService.getCountry();
	}

}
