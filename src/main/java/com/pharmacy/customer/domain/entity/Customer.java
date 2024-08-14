package com.pharmacy.customer.domain.entity;

import java.sql.Date;
import java.util.Calendar;

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

  public int getIdCity() {
    return idCity;
  }

  public void setIdCity(int idCity) {
    this.idCity = idCity;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public java.sql.Date getSqlDate() {
    int year = birthDate.valueOf("y");
    java.sql.Date sqlDate = new java.sql.Date(id, id, id);
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
  
}
