        package com.addi;

import com.addi.maths.SineWave;

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

    /*
     * The phase advances by this amount every timer tick.
     *
     * Increase this value to make the wave move faster.
     * Decrease it to make the wave move more slowly.
     */
    private static final double PHASE_CHANGE_PER_TICK = 45.0;

    private final SineWave sineWave = new SineWave();

    private final Timer animationTimer;

    public WaveGrid() {
        setPreferredSize(new Dimension(700, 350));
        setBackground(Color.BLACK);

        animationTimer = new Timer(
                TIMER_DELAY_MILLISECONDS,
                event -> advancePhase()
        );
    }

    /**
     * Advances the wave's phase and asks Swing to redraw
     * the component.
     */
    private void advancePhase() {
        double nextPhase =
                getPhaseDegrees() + PHASE_CHANGE_PER_TICK;

        setPhaseDegrees(nextPhase % 360.0);
    }

    /**
     * Starts the wave animation.
     */
    public void startAnimation() {
        animationTimer.start();
    }

    /**
     * Stops the wave animation.
     */
    public void stopAnimation() {
        animationTimer.stop();
    }

    /**
     * Returns whether the timer is currently running.
     */
    public boolean isAnimationRunning() {
        return animationTimer.isRunning();
    }

    /**
     * Resets the wave to its starting phase.
     */
    public void resetAnimation() {
        stopAnimation();
        setPhaseDegrees(0.0);
    }

    /**
     * Updates the phase of the sine wave and schedules
     * the panel to be repainted.
     *
     * A positive phase moves the displayed wave to the right
     * when SineWave uses sin(angle - phase).
     */
    public void setPhaseDegrees(double phaseDegrees) {
        sineWave.setPhaseDegrees(phaseDegrees);
        repaint();
    }

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
