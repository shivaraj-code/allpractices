package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Country;
import com.emr.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	
	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country createCountry(Country countryrequest) {
		// TODO Auto-generated method stub
		return countryRepository.save(countryrequest);
	}

	@Override
	public List<Country> getCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

}
