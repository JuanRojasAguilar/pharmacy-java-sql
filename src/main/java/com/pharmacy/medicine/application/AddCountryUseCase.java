package com.pharmacy.country.application;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;

public class AddCountryUseCase {
  private final CountryService countryService;

  public AddCountryUseCase(CountryService countryService) {
    this.countryService = countryService;
  }

  public void execute(Country country) {
    countryService.add(country);
  }
}
