package com.pharmacy.country.infraestructure.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateCountryController extends JFrame implements ActionListener {
  private final JLabel nameLabel;
  private final JTextField nameField;
  private final JButton cancel, register;

  public CreateCountryController() {
    setLayout(null);
    setBounds(0, 0, 330, 150);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    nameLabel = new JLabel("Nombre del pais:");
    nameLabel.setBounds(10, 10, 150, 40);
    add(nameLabel);

    nameField = new JTextField();
    nameField.setBounds(170, 10, 150, 40);
    add(nameField);

    register = new JButton("Registrar");
    register.setBounds(getWidth() >> 2, 60, 100, 30);
    register.setBackground(new Color(0, 200, 45));
    register.setOpaque(true);
    register.setForeground(new Color(255, 255, 255));
    add(register);

    cancel = new JButton("Cancelar");
    cancel.setBounds(getWidth() >> 1, 60, 100, 45);
    cancel.setBackground(new Color(0, 140, 20));
    cancel.setOpaque(true);
    cancel.setForeground(Color.white);
    add(cancel);    

    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
}
