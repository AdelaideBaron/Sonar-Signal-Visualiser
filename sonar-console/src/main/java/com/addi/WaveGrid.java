package com.addi;

import javax.swing.*;
import java.awt.*;

public class WaveGrid extends JPanel {

    public WaveGrid() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.DARK_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        for (int x = 0; x < getWidth(); x += 30) {
            g.drawLine(x, 0, x, getHeight());
        }

        for (int y = 0; y < getHeight(); y += 30) {
            g.drawLine(0, y, getWidth(), y);
        }
    }
}