package com.addi;

import com.addi.unitTesting.maths.SineWave;

import java.awt.*;

public final class SineWaveDrawer {

    private static final Color WAVE_COLOUR = Color.GREEN;
    private static final float WAVE_THICKNESS = 2.0f;

    private SineWaveDrawer() {
        // Utility class: prevent construction
    }

    public static void draw(
            Graphics2D graphics,
            SineWave sineWave,
            int width,
            int height
    ) {
        if (width <= 0 || height <= 0) {
            return;
        }

        int centreY = height / 2;

        graphics.setColor(WAVE_COLOUR);
        graphics.setStroke(new BasicStroke(WAVE_THICKNESS));

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
