        package com.addi;

import com.addi.maths.SineWave;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class WaveGridTest {

    private static final int PANEL_WIDTH = 700;
    private static final int PANEL_HEIGHT = 350;

    private static final Color GRID_COLOUR =
            new Color(0, 100, 0);

    @Test
    void shouldHaveExpectedPreferredSize() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertEquals(
                new Dimension(PANEL_WIDTH, PANEL_HEIGHT),
                waveGrid.getPreferredSize()
        );
    }

    @Test
    void shouldHaveBlackBackground() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertEquals(
                Color.BLACK,
                waveGrid.getBackground()
        );
    }

    @Test
    void shouldBeAJPanel() throws Exception {
        WaveGrid waveGrid = createWaveGridOnEdt();

        assertInstanceOf(JPanel.class, waveGrid);
    }

    @Test
    void shouldDrawVerticalGridLineEveryTwentyFivePixels()
            throws Exception {

        BufferedImage image = paintWaveGrid();

        Color pixelColour = getPixelColour(
                image,
                25,
                10
        );

        assertEquals(GRID_COLOUR, pixelColour);
    }

    @Test
    void shouldDrawHorizontalGridLineEveryTwentyFivePixels()
            throws Exception {

        BufferedImage image = paintWaveGrid();

        Color pixelColour = getPixelColour(
                image,
                10,
                25
        );

        assertEquals(GRID_COLOUR, pixelColour);
    }

    @Test
    void shouldPaintBlackBetweenGridLines() throws Exception {
        BufferedImage image = paintWaveGrid();

        Color pixelColour = getPixelColour(
                image,
                10,
                10
        );

        assertEquals(Color.BLACK, pixelColour);
    }

    @Test
    void shouldDrawBrightGreenCentreLine() throws Exception {
        BufferedImage image = paintWaveGrid();

        int centreY = PANEL_HEIGHT / 2;

        Color pixelColour = getPixelColour(
                image,
                10,
                centreY
        );

        assertEquals(Color.GREEN, pixelColour);
    }

    @Test
    void shouldDrawSineWaveAboveCentreLineAtFirstPeak()
            throws Exception {

        BufferedImage image = paintWaveGrid();

        int peakX = 44;
        int centreY = PANEL_HEIGHT / 2;

        SineWave sineWave = new SineWave();

        int expectedY = sineWave.getY(
                peakX,
                PANEL_WIDTH,
                centreY
        );

        Color pixelColour = getPixelColour(
                image,
                peakX,
                expectedY
        );

        assertEquals(Color.GREEN, pixelColour);
    }


    private Color getPixelColour(
            BufferedImage image,
            int x,
            int y
    ) {
        return new Color(image.getRGB(x, y));
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

            waveGrid.setSize(PANEL_WIDTH, PANEL_HEIGHT);

            BufferedImage image = new BufferedImage(
                    PANEL_WIDTH,
                    PANEL_HEIGHT,
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
