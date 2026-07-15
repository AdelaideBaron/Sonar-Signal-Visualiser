package com.addi;

import javax.swing.*;
import java.awt.*;


public class HomePanel extends JPanel {

    public HomePanel() {
        setPreferredSize(new Dimension(800, 500));

        setBackground(Color.BLACK);

        JLabel title = new JLabel("SONAR CONSOLE");
        title.setForeground(Color.GREEN);

        add(title);
    }
}
