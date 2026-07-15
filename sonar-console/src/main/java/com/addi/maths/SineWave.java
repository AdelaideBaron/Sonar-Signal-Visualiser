package com.addi.maths;


public class SineWave {

    private static final int AMPLITUDE = 80;

    public int getY(int x, int waveLength, int centreY) {
        double angle = 2.0 * Math.PI * x / waveLength;

        return (int) Math.round(
                centreY - AMPLITUDE * Math.sin(angle)
        );
    }
}