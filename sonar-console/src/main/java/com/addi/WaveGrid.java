package com.addi;

import com.addi.maths.SineWave;

import javax.swing.*;
import java.awt.*;

/**
 * size: 700 × 350
 * background: black
 * grid spacing: 25
 * grid colour: (0, 100, 0)
 * bright-green centre line
 * bright-green sine wave
 * */
public class WaveGrid extends JPanel {

    private static final int GRID_SPACING = 25;

    private static final Color GRID_COLOUR =
            new Color(0, 100, 0);

    private final SineWave sineWave = new SineWave();

    public WaveGrid() {
        setPreferredSize(new Dimension(700, 350));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g.create();

        try {
            drawGrid(graphics);
            drawCentreLine(graphics);
            drawSineWave(graphics);
        } finally {
            graphics.dispose();
        }
    }

    private void drawGrid(Graphics2D graphics) {
        graphics.setColor(GRID_COLOUR);

        for (int x = 0; x < getWidth(); x += GRID_SPACING) {
            graphics.drawLine(
                    x,
                    0,
                    x,
                    getHeight()
            );
        }

        for (int y = 0; y < getHeight(); y += GRID_SPACING) {
            graphics.drawLine(
                    0,
                    y,
                    getWidth(),
                    y
            );
        }
    }

    private void drawCentreLine(Graphics2D graphics) {
        int centreY = getHeight() / 2;

        graphics.setColor(Color.GREEN);

        graphics.drawLine(
                0,
                centreY,
                getWidth(),
                centreY
        );
    }

    private void drawSineWave(Graphics2D graphics) {
        int width = getWidth();
        int centreY = getHeight() / 2;

        if (width <= 0) {
            return;
        }

        graphics.setColor(Color.GREEN);
        graphics.setStroke(new BasicStroke(2));

        int previousX = 0;
        int previousY = sineWave.getY(
                previousX,
                width,
                centreY
        );

        for (int x = 1; x < width; x++) {
            int y = sineWave.getY(
                    x,
                    width,
                    centreY
            );

            graphics.drawLine(
                    previousX,
                    previousY,
                    x,
                    y
            );

            previousX = x;
            previousY = y;
        }
    }
}
