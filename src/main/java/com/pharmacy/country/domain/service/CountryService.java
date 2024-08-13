package com.pharmacy.country.domain.service;

import com.pharmacy.country.domain.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
  void add(Country country);
  Optional<Country> findById(int id);
  Optional<List<Country>> showAllInstances();
  void update(Country country);
}
