package com.pharmacy.medicine.application;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class AddMedicineUseCase {
  private final MedicineService medicineService;

  public AddMedicineUseCase(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  public void execute(Medicine medicine) {
    medicineService.add(medicine);
  }
}
