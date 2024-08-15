package com.pharmacy.laboratory.domain.entity;

public class Laboratory {
  private int id;
  private String name;
  private int idCity;

  public Laboratory() {}
  
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIdCity() {
    return this.idCity;
  }

  public void setIdCity(int idCity) {
    this.idCity = idCity;
  }
}
