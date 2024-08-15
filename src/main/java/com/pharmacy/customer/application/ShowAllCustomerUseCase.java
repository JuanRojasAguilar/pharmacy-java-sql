package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.CustomerDTO;
import com.pharmacy.customer.domain.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class ShowAllCustomerUseCase {
  private final CustomerService customerService;

  public ShowAllCustomerUseCase(CustomerService customerService) {
    this.customerService = customerService;
  }

  public Optional<List<CustomerDTO>> execute(int id) {
    return customerService.showAllInstances();
  }
}
