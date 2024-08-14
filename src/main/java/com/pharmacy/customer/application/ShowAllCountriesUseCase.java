package com.pharmacy.country.application;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;

import java.util.List;
import java.util.Optional;

public class ShowAllCountriesUseCase {
  private final CountryService countryService;

  public ShowAllCountriesUseCase(CountryService countryService) {
    this.countryService = countryService;
  }

  public Optional<List<Country>> execute(int id) {
    return countryService.showAllInstances();
  }
}
