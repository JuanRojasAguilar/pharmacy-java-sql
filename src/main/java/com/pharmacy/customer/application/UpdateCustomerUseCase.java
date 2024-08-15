package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class UpdateCustomerUseCase {
  private final CustomerService customerService;

  public UpdateCustomerUseCase(CustomerService customerService) {
    this.customerService = customerService;
  }

  public void execute(Customer customer) {
    customerService.update(customer);
  }
}
