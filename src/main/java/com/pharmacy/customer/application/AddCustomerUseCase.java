package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.CustomerDTO;
import com.pharmacy.customer.domain.service.CustomerService;

public class AddCustomerUseCase {
  private final CustomerService customerService;

  public AddCustomerUseCase(CustomerService customerService) {
    this.customerService = customerService;
  }

  public void execute(CustomerDTO customer) {
    customerService.add(customer);
  }
}
