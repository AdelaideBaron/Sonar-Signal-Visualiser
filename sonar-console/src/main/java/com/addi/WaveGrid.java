        package com.addi;

import com.addi.unitTesting.maths.SineWave;

import javax.swing.*;
import java.awt.*;

/**
 * Displays an animated sonar-style grid and sine waveform.
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

    private static final int TIMER_DELAY_MILLISECONDS = 250;

    private final SineWave sineWave = new SineWave();
    private final Timer animationTimer;

    /**
     * Frequency in Hertz: cycles per second.
     */
    private double frequency;

    public WaveGrid(double frequency) {
        validateFrequency(frequency);

        this.frequency = frequency;

        setPreferredSize(new Dimension(700, 350));
        setBackground(Color.BLACK);

        animationTimer = new Timer(
                TIMER_DELAY_MILLISECONDS,
                event -> advancePhase()
        );
    }

    private void advancePhase() {
        double secondsPerTick =
                TIMER_DELAY_MILLISECONDS / 1000.0;

        double phaseChange =
                360.0 * frequency * secondsPerTick;

        double nextPhase =
                getPhaseDegrees() + phaseChange;

        setPhaseDegrees(nextPhase % 360.0);
    }

    public void startAnimation() {
        animationTimer.start();
    }

    public void stopAnimation() {
        animationTimer.stop();
    }

    public boolean isAnimationRunning() {
        return animationTimer.isRunning();
    }

    public void resetAnimation() {
        stopAnimation();
        setPhaseDegrees(0.0);
    }

    public void setFrequency(double frequency) {
        validateFrequency(frequency);
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setPhaseDegrees(double phaseDegrees) {
        sineWave.setPhaseDegrees(phaseDegrees);
        repaint();
    }

    public double getPhaseDegrees() {
        return sineWave.getPhaseDegrees();
    }

    private void validateFrequency(double frequency) {
        if (!Double.isFinite(frequency) || frequency <= 0.0) {
            throw new IllegalArgumentException(
                    "Frequency must be a positive, finite number."
            );
        }
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
