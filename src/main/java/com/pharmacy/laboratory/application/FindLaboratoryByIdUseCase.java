package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;
import java.util.Optional;

public class FindLaboratoryByIdUseCase {
  private final LaboratoryService laboratoryService;

  public FindLaboratoryByIdUseCase(LaboratoryService laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  public Optional<Laboratory> execute(int id) {
    return laboratoryService.findById(id);
  }
}
