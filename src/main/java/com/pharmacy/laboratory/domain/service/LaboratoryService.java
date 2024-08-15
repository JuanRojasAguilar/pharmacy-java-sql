package com.pharmacy.laboratory.domain.service;

import com.pharmacy.laboratory.domain.entity.Laboratory;

import java.util.List;
import java.util.Optional;

public interface LaboratoryService {
  void add(Laboratory laboratory);
  Optional<Laboratory> findById(int id);
  Optional<List<Laboratory>> showAllInstances();
  void update(Laboratory laboratory);
}
