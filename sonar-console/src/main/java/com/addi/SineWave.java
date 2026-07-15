package com.addi;

public class SineWave {

    public int getY(int x, int width, int centreY) {
        double angle =
                ((double)x / width)
                        * 4
                        * 2
                        * Math.PI;

        return centreY - (int)(Math.sin(angle) * 80);
    }
}
