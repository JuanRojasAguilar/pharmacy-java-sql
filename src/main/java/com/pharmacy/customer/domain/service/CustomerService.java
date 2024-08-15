package com.pharmacy.customer.domain.service;

import com.pharmacy.customer.domain.entity.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
  void add(CustomerDTO customer);
  Optional<CustomerDTO> findById(int id);
  Optional<List<CustomerDTO>> showAllInstances();
  void update(CustomerDTO customer);
  void delete(int id);
}
