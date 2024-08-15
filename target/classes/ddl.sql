DROP DATABASE IF EXISTS juan_pharmacy;
CREATE DATABASE juan_pharmacy;
USE juan_pharmacy;

CREATE TABLE countries (
  id_country INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR (80),
  CONSTRAINT pk_id_country PRIMARY KEY (id_country)
);

CREATE TABLE regions (
  id_region INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(50),
  id_country INT UNSIGNED,
  CONSTRAINT pk_id_region PRIMARY KEY (id_region),
  CONSTRAINT fk_id_country_region FOREIGN KEY (id_country)
  REFERENCES countries (id_country) 
);

CREATE TABLE cities (
  id_city INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(50),
  id_region INT UNSIGNED,
  CONSTRAINT pk_id_city PRIMARY KEY (id_city),
  CONSTRAINT fk_id_region_city FOREIGN KEY (id_region)
  REFERENCES regions(id_region)
);

CREATE TABLE customers (
  id_customer VARCHAR(20) UNIQUE NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  id_city INT UNSIGNED,
  email VARCHAR(100) UNIQUE NOT NULL,
  birth_date DATE NOT NULL,
  longitude DECIMAL(8,6),
  latitude DECIMAL(8,6),
  CONSTRAINT pk_id_customer PRIMARY KEY (id_customer),
  CONSTRAINT fk_id_city_customer FOREIGN KEY (id_city)
  REFERENCES cities (id_city)
);

CREATE TABLE laboratories (
  id_laboratory INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  id_city INT UNSIGNED,
  CONSTRAINT pk_id_laboratory PRIMARY KEY (id_laboratory),
  CONSTRAINT fk_id_city_laboratory FOREIGN KEY (id_city)
  REFERENCES cities (id_city)
);

CREATE TABLE active_principles (
  id_principle INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  CONSTRAINT pk_id_principle PRIMARY KEY (id_principle)
);

CREATE TABLE medication_vias (
  id_via INT UNSIGNED AUTO_INCREMENT,
  description VARCHAR(60) NOT NULL,
  CONSTRAINT pk_id_via PRIMARY KEY (id_via)
);

CREATE TABLE measurement_units (
  id_unit INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT pk_id_unit PRIMARY KEY (id_unit)
);

CREATE TABLE pharmacies (
  id_pharmacy INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  address VARCHAR(100),
  longitude DECIMAL(8,8),
  latitude DECIMAL(8,8),
  id_city INT UNSIGNED,
  logo_pharmacy VARCHAR(50),
  CONSTRAINT pk_id_pharmacy PRIMARY KEY (id_pharmacy),
  CONSTRAINT fk_id_city_pharmacy FOREIGN KEY (id_city)
  REFERENCES cities (id_city)
);

CREATE TABLE medicines (
  id_medicine INT UNSIGNED AUTO_INCREMENT,
  proceeding VARCHAR(10),
  name VARCHAR(100) UNIQUE,
  health_register VARCHAR(50) NOT NULL,
  description TEXT,
  description_short VARCHAR(60),
  id_via INT UNSIGNED,
  id_principle INT UNSIGNED,
  id_unit INT UNSIGNED,
  rol_name VARCHAR(100),
  id_laboratory INT UNSIGNED,
  CONSTRAINT pk_id_medicine PRIMARY KEY (id_medicine),
  CONSTRAINT fk_id_via_medicine FOREIGN KEY (id_via)
  REFERENCES medication_vias(id_via),
  CONSTRAINT fk_id_principle_medicine FOREIGN KEY (id_principle)
  REFERENCES active_principles (id_principle),
  CONSTRAINT fk_id_unit_medicine FOREIGN KEY (id_unit)
  REFERENCES measurement_units (id_unit),
  CONSTRAINT fk_id_laboratory_medicine FOREIGN KEY (id_laboratory)
  REFERENCES laboratories (id_laboratory)
);

