package com.addi.unitTesting.maths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SineWaveTest {

  private static final int WAVE_LENGTH = 700;
  private static final int CENTRE_Y = 175;
  private static final int AMPLITUDE = 80;

  private final SineWave sineWave = new SineWave();

  @Test
  void shouldReturnCentreYAtStartOfWave() {
    assertEquals(CENTRE_Y, sineWave.getY(0, WAVE_LENGTH, CENTRE_Y));
  }

  @Test
  void shouldReturnCentreYAtEndOfWave() {
    assertEquals(CENTRE_Y, sineWave.getY(WAVE_LENGTH, WAVE_LENGTH, CENTRE_Y));
  }

  @Test
  void shouldNeverExceedAmplitude() {

    for (int x = 0; x <= WAVE_LENGTH; x++) {

      int y = sineWave.getY(x, WAVE_LENGTH, CENTRE_Y);

      assertTrue(
          y >= CENTRE_Y - AMPLITUDE && y <= CENTRE_Y + AMPLITUDE, "Unexpected y value at x=" + x);
    }
  }

  @Test
  void shouldReachFirstPeak() {

    int firstPeak = 44;

    int y = sineWave.getY(firstPeak, WAVE_LENGTH, CENTRE_Y);

    assertEquals(96, y, 2);
  }

  @Test
  void shouldReachFirstTrough() {

    int firstTrough = 131;

    int y = sineWave.getY(firstTrough, WAVE_LENGTH, CENTRE_Y);

    assertEquals(254, y, 2);
  }

  @Test
  void shouldMoveWaveToTheRightWhenPhaseIncreases() {

    int original = sineWave.getY(0, WAVE_LENGTH, CENTRE_Y);

    sineWave.setPhaseDegrees(90);

    int shifted = sineWave.getY(0, WAVE_LENGTH, CENTRE_Y);

    assertNotEquals(original, shifted);

    assertEquals(CENTRE_Y + AMPLITUDE, shifted, 2);
  }

  @Test
  void shouldReturnToOriginalPositionAfterThreeHundredAndSixtyDegrees() {

    int original = sineWave.getY(0, WAVE_LENGTH, CENTRE_Y);

    sineWave.setPhaseDegrees(360);

    int shifted = sineWave.getY(0, WAVE_LENGTH, CENTRE_Y);

    assertEquals(original, shifted);
  }

  @Test
  void shouldAllowPhaseToBeUpdated() {

    sineWave.setPhaseDegrees(135);

    assertEquals(135, sineWave.getPhaseDegrees());
  }
}
