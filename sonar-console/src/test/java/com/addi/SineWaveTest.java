package com.addi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SineWaveTest {

    private final SineWave sineWave = new SineWave();

    @Test
    void shouldReturnCentreYAtStartOfWave() {
        int y = sineWave.getY(0, 700, 175);

        assertEquals(175, y);
    }

    @Test
    void shouldReturnCentreYAfterOneCompleteCycle() {
        int y = sineWave.getY(700, 700, 175);

        assertEquals(175, y);
    }

    @Test
    void shouldNeverExceedMaximumAmplitude() {

        int centreY = 175;

        for (int x = 0; x <= 700; x++) {

            int y = sineWave.getY(x, 700, centreY);

            assertEquals(
                    true,
                    y >= centreY - 80 && y <= centreY + 80
            );
        }
    }

    @Test
    void shouldReachPeakAmplitudeApproximatelyQuarterCycle() {

        int y = sineWave.getY(44, 700, 175);

        assertEquals(95, y, 2);
    }

    @Test
    void shouldReachMinimumAmplitudeApproximatelyThreeQuarterCycle() {

        int y = sineWave.getY(131, 700, 175);

        assertEquals(255, y, 2);
    }
}

