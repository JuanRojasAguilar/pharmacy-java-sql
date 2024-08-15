package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class AddCustomerUseCase {
  private final CustomerService customerService;

  public AddCustomerUseCase(CustomerService customerService) {
    this.customerService = customerService;
  }

  public void execute(Customer customer) {
    customerService.add(customer);
  }
}
