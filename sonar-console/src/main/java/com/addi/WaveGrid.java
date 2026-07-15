package com.addi;

import com.addi.maths.SineWave;

import javax.swing.*;
import java.awt.*;

/**
 * Displays a sonar-style grid and sine waveform.
 *
 * Size: 700 × 350
 * Background: black
 * Grid spacing: 25
 * Grid colour: RGB(0, 100, 0)
 * Centre line: bright green
 * Wave: bright green
 */
public class WaveGrid extends JPanel {

    private static final int GRID_SPACING = 25;

    private static final Color GRID_COLOUR =
            new Color(0, 100, 0);

    private final SineWave sineWave = new SineWave();

    public WaveGrid() {
        setPreferredSize(new Dimension(700, 350));
        setBackground(Color.BLACK);
    }

    /**
     * Updates the phase of the sine wave and redraws the panel.
     *
     * A positive phase moves the displayed wave to the right,
     * assuming SineWave uses sin(angle - phase).
     */
    public void setPhaseDegrees(double phaseDegrees) {
        sineWave.setPhaseDegrees(phaseDegrees);
        repaint();
    }

    // To draw, we want to call Wave Grid paintComponent multiple times, perhaps every second? And just update the phase and then re-display?


    public double getPhaseDegrees() {
        return sineWave.getPhaseDegrees();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D =
                (Graphics2D) graphics.create();

        try {
            drawGrid(graphics2D);
            drawCentreLine(graphics2D);

            SineWaveDrawer.draw(
                    graphics2D,
                    sineWave,
                    getWidth(),
                    getHeight()
            );
        } finally {
            graphics2D.dispose();
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
}
