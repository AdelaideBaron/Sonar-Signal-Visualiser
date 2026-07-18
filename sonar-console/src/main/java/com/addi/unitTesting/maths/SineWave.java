package com.addi.unitTesting.maths;

public class SineWave {

  private final int amplitude;
  private final double numberOfCycles;
  private double phaseDegrees;

  public SineWave() {
    this(80, 4.0, 0.0);
  }

  /** signal = amplitude × sin(angle) where angle = 2π × frequency × time */

  /**
   * PHASES
   *
   * <p>0° normal starting position 90° shifted right by one quarter-cycle 180° shifted right by
   * half a cycle 270° shifted right by three quarters 360° visually identical to 0°
   */
  public SineWave(int amplitude, double numberOfCycles, double phaseDegrees) {
    this.amplitude = amplitude;
    this.numberOfCycles = numberOfCycles;
    this.phaseDegrees = phaseDegrees;
  }

  public int getY(int x, int width, int centreY) {
    if (width <= 0) {
      return centreY;
    }

    double progress = (double) x / width;

    double phaseRadians = Math.toRadians(phaseDegrees);

    double angle = progress * numberOfCycles * 2 * Math.PI;

    double value = Math.sin(angle - phaseRadians);

    return centreY - (int) (value * amplitude);
  }

  public void setPhaseDegrees(double phaseDegrees) {
    this.phaseDegrees = phaseDegrees;
  }

  public double getPhaseDegrees() {
    return phaseDegrees;
  }
}
