package com.pharmacy.customer.infraestructure.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.infraestructure.repository.CountryRepository;

public class CreateCustomerController extends JFrame implements ActionListener {
  private CountryRepository countryRepository;

  private JLabel idLabel, firstNameLabel, lastNameLabel, countryLabel, cityLabel, emailLabel, dateLabel, longitudeLabel, latitudeLabel;
  private JTextField idField, firstNameField, lastNameField, emailField, longitudField, latitudeField;
  private JButton cancel, register;
  private JComboBox countries;

  public CreateCustomerController() {
    setLayout(null);
    setBounds(0, 0, 460, 600);

    idLabel = new JLabel("ID:");
    idLabel.setBounds(10, 10, 200, 30);
    add(idLabel);

    idField = new JTextField();
    idField.setBounds(220, 10, 200, 30);
    add(idField);

    firstNameLabel = new JLabel("Nombre del cliente:");
    firstNameLabel.setBounds(10, 60, 200, 30);
    add(firstNameLabel);

    firstNameField = new JTextField();
    firstNameField.setBounds(220, 60, 200,30);
    add(firstNameField);

    lastNameLabel = new JLabel("Apellido del cliente:");
    lastNameLabel.setBounds(10, 110, 200, 30);
    add(lastNameLabel);

    lastNameField = new JTextField();
    lastNameField.setBounds(220, 110, 200, 30);
    add(lastNameField);

    countryLabel = new JLabel("Seleccione el pais:");
    countryLabel.setBounds(10, 160, 200, 30);
    add(countryLabel);

    countries = new JComboBox<String>();
    countries.setBounds(220, 160, 200, 30);
    addCountriesToBox(countries);
    add(countries);

    register = new JButton("Registrar");
    register.setBounds(getWidth() >> 3, 210, 150, 30);
    register.setBackground(new Color(0, 200, 45));
    register.setOpaque(true);
    register.setForeground(new Color(255, 255, 255));
    add(register);

    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
  }

  private void addCountriesToBox(JComboBox comboBox) {
    countryRepository = new CountryRepository();
    Optional<List<Country>> countryList = countryRepository.showAllInstances();
    countryList.ifPresent(list -> {
      list.forEach((Country c) -> {
        comboBox.addItem(c.getName());
      });
    }); 
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
}
