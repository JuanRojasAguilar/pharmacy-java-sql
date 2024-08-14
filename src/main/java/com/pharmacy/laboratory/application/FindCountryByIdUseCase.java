package com.pharmacy.country.application;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;
import java.util.Optional;

public class FindCountryByIdUseCase {
  private final CountryService countryService;

  public FindCountryByIdUseCase(CountryService countryService) {
    this.countryService = countryService;
  }

  public Optional<Country> execute(int id) {
    return countryService.findById(id);
  }
}
