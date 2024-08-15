package com.pharmacy.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.pharmacy.country.infraestructure.controller.CountryController;
import com.pharmacy.customer.infraestructure.controller.CustomerController;

public class PeopleMenu extends JFrame implements ActionListener {
    private final JButton customers, countries;
    
    public PeopleMenu() {
        setLayout(null);
        setBounds(0, 0, 220, 480);

        customers = new JButton("Menu Clientes");
        customers.setBounds(10, 60, 200, 40);
        customers.addActionListener(this);
        add(customers);

        countries = new JButton("Paises");
        countries.setBounds(10, 110, 200, 40);
        countries.addActionListener(this);
        add(countries);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customers) {
            CustomerController cc = new CustomerController();
        }
        if (e.getSource() == countries) {
            CountryController cc = new CountryController();
        }
        this.dispose();
    }
}
