package com.addi.maths;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SineWaveTest {

    private final SineWave sineWave = new SineWave();

    private static final int WAVE_LENGTH = 700;
    private static final int CENTRE_Y = 175;
    private static final int AMPLITUDE = 80;

    @Test
    void shouldReturnCentreYAtStartOfWave() {
        int y = sineWave.getY(0, WAVE_LENGTH, CENTRE_Y);

        assertEquals(CENTRE_Y, y);
    }

    @Test
    void shouldReturnCentreYAfterOneCompleteCycle() {
        int y = sineWave.getY(WAVE_LENGTH, WAVE_LENGTH, CENTRE_Y);

        assertEquals(CENTRE_Y, y);
    }

    @Test
    void shouldNeverExceedMaximumAmplitude() {
        for (int x = 0; x <= WAVE_LENGTH; x++) {
            int y = sineWave.getY(x, WAVE_LENGTH, CENTRE_Y);

            assertTrue(
                    y >= CENTRE_Y - AMPLITUDE
                            && y <= CENTRE_Y + AMPLITUDE,
                    "y was outside the expected range at x=" + x + ": " + y
            );
        }
    }

    @Test
    void shouldReachPeakAmplitudeAtQuarterCycle() {
        int quarterCycle = WAVE_LENGTH / 4;

        int y = sineWave.getY(quarterCycle, WAVE_LENGTH, CENTRE_Y);

        assertEquals(95, y, 2);
    }

    @Test
    void shouldReachMinimumAmplitudeAtThreeQuarterCycle() {
        int threeQuarterCycle = WAVE_LENGTH * 3 / 4;

        int y = sineWave.getY(threeQuarterCycle, WAVE_LENGTH, CENTRE_Y);

        assertEquals(255, y, 2);
    }
}
