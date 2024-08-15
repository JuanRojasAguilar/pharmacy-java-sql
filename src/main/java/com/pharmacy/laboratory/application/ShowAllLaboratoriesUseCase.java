package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

import java.util.List;
import java.util.Optional;

public class ShowAllLaboratoriesUseCase {
  private final LaboratoryService laboratoryService;

  public ShowAllLaboratoriesUseCase(LaboratoryService laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  public Optional<List<Laboratory>> execute(int id) {
    return laboratoryService.showAllInstances();
  }
}
