package com.codecool.acsbencetamas.pa.ant;

import java.util.Random;

public class Util {

    // Inclusive
    public static int randomBetween(int lower, int upper) {
        return (int) (Math.random() * (upper - lower + 1) + lower);
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    public static int getDistance(Insect insect1, Insect insect2) {
        return getDistance(insect1.x, insect1.y, insect2.x, insect2.y);
    }

    public static int randomSign() {
        Random random = new Random();
        return (random.nextBoolean() ? -1 : 1);
    }
}
