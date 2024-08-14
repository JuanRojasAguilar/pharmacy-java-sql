package com.pharmacy.customer.domain.service;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.entity.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
  void add(Customer customer);
  Optional<Customer> findById(int id);
  Optional<List<CustomerDTO>> showAllInstances();
  void update(Customer customer);
  void delete(int id);
}
