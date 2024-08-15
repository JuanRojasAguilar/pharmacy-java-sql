package com.pharmacy.laboratory.infraestructure.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateLaboratoryController extends JFrame implements ActionListener {
  private JLabel nameLabel;
  private JTextField nameField;
  private JButton cancel, register;

  public CreateLaboratoryController() {
    setLayout(null);
    setBounds(0, 0, 330, 150);

    nameLabel = new JLabel("Nombre del pais:");
    nameLabel.setBounds(10, 10, 150, 40);
    add(nameLabel);

    nameField = new JTextField();
    nameField.setBounds(170, 10, 150, 40);
    add(nameField);

    register = new JButton("Registrar");
    register.setBounds(getWidth() >> 2, 60, 70, 30);
    register.setBackground(new Color(0, 200, 45));
    register.setOpaque(true);
    register.setForeground(new Color(255, 255, 255));
    add(register);

    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
}
