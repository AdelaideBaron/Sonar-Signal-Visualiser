package com.addi.UITesting;



import com.addi.WaveGrid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
        import java.awt.*;
        import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class WaveGridUITest extends UITest {

    private WaveGrid waveGrid;

    @AfterEach
    void stopTimerAfterEachTest() {
        if (waveGrid != null) {
            waveGrid.stopAnimation();
        }
    }

    @Test
    void backgroundIsBlack() {
        waveGrid = new WaveGrid(0.5);

        assertEquals(Color.BLACK, waveGrid.getBackground());
    }

    @Test
    void preferredSizeIsCorrect() {
        waveGrid = new WaveGrid(0.5);

        assertEquals(
                new Dimension(700, 350),
                waveGrid.getPreferredSize()
        );
    }

    @Test
    void storesInitialFrequency() {
        waveGrid = new WaveGrid(0.5);

        assertEquals(0.5, waveGrid.getFrequency());
    }

    @Test
    void frequencyCanBeChanged() {
        waveGrid = new WaveGrid(0.5);

        waveGrid.setFrequency(2.0);

        assertEquals(2.0, waveGrid.getFrequency());
    }

    @Test
    void phaseCanBeChanged() {
        waveGrid = new WaveGrid(0.5);

        waveGrid.setPhaseDegrees(90.0);

        assertEquals(90.0, waveGrid.getPhaseDegrees());
    }

    @Test
    void animationIsInitiallyStopped() {
        waveGrid = new WaveGrid(0.5);

        assertFalse(waveGrid.isAnimationRunning());
    }

    @Test
    void animationCanBeStarted() {
        waveGrid = new WaveGrid(0.5);

        waveGrid.startAnimation();

        assertTrue(waveGrid.isAnimationRunning());
    }

    @Test
    void animationCanBeStopped() {
        waveGrid = new WaveGrid(0.5);

        waveGrid.startAnimation();
        waveGrid.stopAnimation();

        assertFalse(waveGrid.isAnimationRunning());
    }

    @Test
    void resetStopsAnimationAndSetsPhaseToZero() {
        waveGrid = new WaveGrid(0.5);

        waveGrid.setPhaseDegrees(180.0);
        waveGrid.startAnimation();

        waveGrid.resetAnimation();

        assertFalse(waveGrid.isAnimationRunning());
        assertEquals(0.0, waveGrid.getPhaseDegrees());
    }

    @Test
    void constructorRejectsZeroFrequency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new WaveGrid(0.0)
        );
    }

    @Test
    void constructorRejectsNegativeFrequency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new WaveGrid(-1.0)
        );
    }

    @Test
    void constructorRejectsNaNFrequency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new WaveGrid(Double.NaN)
        );
    }

    @Test
    void constructorRejectsInfiniteFrequency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new WaveGrid(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    void setFrequencyRejectsInvalidFrequency() {
        waveGrid = new WaveGrid(0.5);

        assertThrows(
                IllegalArgumentException.class,
                () -> waveGrid.setFrequency(-2.0)
        );
    }

    @Test
    void centreLineIsGreen() {
        waveGrid = new WaveGrid(0.5);
        waveGrid.setSize(700, 350);

        BufferedImage image = paintPanel(waveGrid);

        int centreY = waveGrid.getHeight() / 2;
        Color centrePixel = new Color(image.getRGB(10, centreY));

        assertEquals(Color.GREEN, centrePixel);
    }

    @Test
    void backgroundAreaIsBlack() {
        waveGrid = new WaveGrid(0.5);
        waveGrid.setSize(700, 350);

        BufferedImage image = paintPanel(waveGrid);

        Color pixel = new Color(image.getRGB(13, 13));

        assertEquals(Color.BLACK, pixel);
    }

    private BufferedImage paintPanel(JPanel panel) {
        BufferedImage image = new BufferedImage(
                panel.getWidth(),
                panel.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D graphics = image.createGraphics();

        try {
            panel.paint(graphics);
        } finally {
            graphics.dispose();
        }

        return image;
    }
}

