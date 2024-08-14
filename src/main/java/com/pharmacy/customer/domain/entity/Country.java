package com.pharmacy.customer.domain.entity;

import java.sql.Date;

public class Customer {
  private int id;
  private String firstName;
  private String lastName;
  private int id_city;
  private String email;
  private Date birthDate;
  private double longitude;
  private double latitude;

  public Customer() {}
  
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
}
