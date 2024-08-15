package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.CustomerDTO;
import com.pharmacy.customer.domain.service.CustomerService;
import java.util.Optional;

public class FindCustomerByIdUseCase {
  private final CustomerService customerService;

  public FindCustomerByIdUseCase(CustomerService customerService) {
    this.customerService = customerService;
  }

  public Optional<CustomerDTO> execute(int id) {
    return customerService.findById(id);
  }
}
