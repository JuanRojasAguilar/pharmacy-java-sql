package com.pharmacy.medicine.application;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class UpdateMedicineUseCase {
  private final MedicineService medicineService;

  public UpdateMedicineUseCase(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  public void execute(Medicine medicine) {
    medicineService.update(medicine);
  }
}
