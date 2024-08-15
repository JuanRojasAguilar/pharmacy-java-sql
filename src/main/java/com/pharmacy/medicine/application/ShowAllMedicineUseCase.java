package com.pharmacy.medicine.application;

import java.util.List;
import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class ShowAllMedicineUseCase {
  private final MedicineService medicineService;

  public ShowAllMedicineUseCase(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  public Optional<List<Medicine>> execute(int id) {
    return medicineService.showAllInstances();
  }
}
