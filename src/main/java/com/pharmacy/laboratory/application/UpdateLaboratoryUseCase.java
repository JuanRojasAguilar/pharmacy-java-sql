package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class UpdateLaboratoryUseCase {
  private final LaboratoryService laboratoryService;

  public UpdateLaboratoryUseCase(LaboratoryService laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  public void execute(Laboratory laboratory) {
    laboratoryService.update(laboratory);
  }
}
