package com.pharmacy.customer.domain.entity;

import java.sql.Date;

public class Customer {
  private int id;
  private String firstName;
  private String lastName;
  private int idCity;
  private String email;
  private Date birthDate;
  private double longitude;
  private double latitude;

  public Customer() {}
  
  public Customer(int id, String firstName, String lastName, int idCity, String email, Date birthDate, double longitude, double latitude) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.idCity = idCity;
    this.email = email;
    this.birthDate = birthDate;
    this.longitude = longitude;
    this.latitude = latitude;
  }
  
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
