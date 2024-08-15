package com.pharmacy.medicine.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;

public interface MedicineService {
  void add(Medicine country);
  Optional<Medicine> findById(int id);
  Optional<List<Medicine>> showAllInstances();
  void update(Medicine medicine);
}
