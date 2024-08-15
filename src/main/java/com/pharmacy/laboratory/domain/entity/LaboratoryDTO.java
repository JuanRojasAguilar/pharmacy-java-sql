
package com.pharmacy.laboratory.domain.entity;

public class LaboratoryDTO {
  private int id;
  private String name;
  private String city;

  public LaboratoryDTO() {}

  public LaboratoryDTO(int id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }
  
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

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
