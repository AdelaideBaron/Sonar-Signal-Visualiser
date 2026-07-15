package com.addi;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class WaveGridTest {

    @Test
    void shouldHaveExpectedPreferredSize() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertEquals(
                new Dimension(500, 500),
                waveGrid.getPreferredSize()
        );
    }

    @Test
    void shouldHaveDarkGrayBackground() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertEquals(
                Color.DARK_GRAY,
                waveGrid.getBackground()
        );
    }

    @Test
    void shouldBeAJPanel() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertInstanceOf(JPanel.class, waveGrid);
    }

    @Test
    void shouldDrawGreenVerticalGridLineAtThirtyPixels() throws Exception {
        BufferedImage image = paintWaveGrid();

        Color pixelColour = new Color(image.getRGB(30, 15));

        assertEquals(Color.GREEN, pixelColour);
    }

    @Test
    void shouldDrawGreenHorizontalGridLineAtThirtyPixels() throws Exception {
        BufferedImage image = paintWaveGrid();

        Color pixelColour = new Color(image.getRGB(15, 30));

        assertEquals(Color.GREEN, pixelColour);
    }

    @Test
    void shouldPaintDarkGrayBetweenGridLines() throws Exception {
        BufferedImage image = paintWaveGrid();

        Color pixelColour = new Color(image.getRGB(15, 15));

        assertEquals(Color.DARK_GRAY, pixelColour);
    }

    private WaveGrid createWaveGridOnEdt()
            throws InvocationTargetException, InterruptedException {

        WaveGrid[] result = new WaveGrid[1];

        SwingUtilities.invokeAndWait(() ->
                result[0] = new WaveGrid()
        );

        return result[0];
    }

    private BufferedImage paintWaveGrid()
            throws InvocationTargetException, InterruptedException {

        BufferedImage[] result = new BufferedImage[1];

        SwingUtilities.invokeAndWait(() -> {
            WaveGrid waveGrid = new WaveGrid();

            waveGrid.setSize(500, 500);

            BufferedImage image = new BufferedImage(
                    500,
                    500,
                    BufferedImage.TYPE_INT_RGB
            );

            Graphics2D graphics = image.createGraphics();

            try {
                waveGrid.paint(graphics);
            } finally {
                graphics.dispose();
            }

            result[0] = image;
        });

        return result[0];
    }
}
