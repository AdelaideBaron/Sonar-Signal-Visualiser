package com.addi;

import javax.swing.*;
import java.awt.*;


public class HomePanel {

    public JPanel panel = new JPanel();

    public HomePanel() {

        panel.setBackground(Color.BLACK);

        JLabel title = new JLabel("SONAR CONSOLE");
        title.setForeground(Color.GREEN);

        JTextField field = new JTextField(20);

        JButton button = new JButton("Submit");

        panel.add(title);
        panel.add(field);
        panel.add(button);
    }
}
