package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class AddLaboratoryUseCase {
  private final LaboratoryService laboratoryService;

  public AddLaboratoryUseCase(LaboratoryService laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  public void execute(Laboratory laboratory) {
    laboratoryService.add(laboratory);
  }
}
