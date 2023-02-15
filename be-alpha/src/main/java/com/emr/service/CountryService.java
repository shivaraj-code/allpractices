package com.emr.service;

import java.util.List;

import com.emr.model.Country;

public interface CountryService {

	Country createCountry(Country countryrequest);

	List<Country> getCountry();

}
