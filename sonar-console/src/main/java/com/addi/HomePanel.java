package com.addi;

import javax.swing.*;
import java.awt.*;


public class HomePanel extends JPanel {

    public HomePanel() {
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("SONAR CONSOLE");
        title.setForeground(Color.GREEN);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        WaveGrid waveGrid = new WaveGrid();

        add(title, BorderLayout.NORTH);
        add(waveGrid, BorderLayout.CENTER);
        add(new DigitalClockPanel(), BorderLayout.SOUTH);


        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

    }
}
