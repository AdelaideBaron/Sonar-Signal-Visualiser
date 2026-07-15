package com.addi;

import javax.swing.*;
import java.awt.*;


public class HomePanel {

    public JPanel panel = new JPanel();

    public HomePanel() {

        panel.setBackground(Color.BLACK);

        JLabel title = new JLabel("SONAR CONSOLE");
        title.setForeground(Color.GREEN);



        panel.add(title);
    }
}
