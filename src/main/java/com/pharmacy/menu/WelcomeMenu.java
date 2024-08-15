package com.pharmacy.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeMenu extends JFrame implements ActionListener {
    private final JLabel welcomeLabel;
    private final JButton peopleMenu, medicineMenu;
    
    public WelcomeMenu() {
        setLayout(null);
        setBounds(0, 0, 480, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        welcomeLabel = new JLabel("Bienvenido a farmacias");
        welcomeLabel.setBounds(getWidth() >> 2, 10, 200, 60);
        add(welcomeLabel);
        
        peopleMenu = new JButton("Administrar Clientes");
        peopleMenu.setBounds(10, 50, 220, 40);
        peopleMenu.addActionListener(this);
        add(peopleMenu);
        
        medicineMenu = new JButton("Administrar Medicamentos");
        medicineMenu.setBounds(240, 50, 220, 40);
        medicineMenu.addActionListener(this);
        add(medicineMenu);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == peopleMenu) {
            PeopleMenu pm = new PeopleMenu();
        }
    }
}
