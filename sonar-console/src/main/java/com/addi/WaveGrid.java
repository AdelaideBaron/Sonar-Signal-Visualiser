package com.addi;

import javax.swing.*;
import java.awt.*;

public class WaveGrid extends JPanel {

    private static final int GRID_SPACING = 25;

    public WaveGrid() {
        setPreferredSize(new Dimension(700, 350));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(0, 100, 0));

        // vertical grid
        for (int x = 0; x < getWidth(); x += GRID_SPACING) {
            g.drawLine(x, 0, x, getHeight());
        }

        // horizontal grid
        for (int y = 0; y < getHeight(); y += GRID_SPACING) {
            g.drawLine(0, y, getWidth(), y);
        }

        // centre line (where the waveform will be drawn)
        g.setColor(Color.GREEN);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
    }
}