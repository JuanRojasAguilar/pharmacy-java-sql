package com.pharmacy.country.infraestructure.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CountryController extends JFrame implements ActionListener {
  private JButton addNew, search, list, update, delete;

  public CountryController() {
    setLayout(null);
    setLocationRelativeTo(null);
    setBounds(0, 0, 220, 360);

    addNew = new JButton("Añadir Pais");
    addNew.setBounds(10, 10, 200, 50);
    addNew.addActionListener(this);
    add(addNew);

    search = new JButton("Buscar Pais");
    search.setBounds(10, 70, 200, 50);
    search.addActionListener(this);
    add(search);

    list = new JButton("Mostrar paises");
    list.setBounds(10, 130, 200, 50);
    list.addActionListener(this);
    add(list);

    update = new JButton("Actualizar pais");
    update.setBounds(10, 190, 200, 50);
    update.addActionListener(this);
    add(update);

    delete = new JButton("Eliminar pais");
    delete.setBounds(10, 250, 200, 50);
    delete.addActionListener(this);
    add(delete);

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addNew) {
      CreateCountryController controller = new CreateCountryController();
    }
  }
}
