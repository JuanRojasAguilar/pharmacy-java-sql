package com.pharmacy.medicine.application;

import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class FindMedicineByIdUseCase {
  private final MedicineService medicineService;

  public FindMedicineByIdUseCase(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  public Optional<Medicine> execute(int id) {
    return medicineService.findById(id);
  }
}
