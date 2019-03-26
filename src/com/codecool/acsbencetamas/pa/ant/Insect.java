package com.codecool.acsbencetamas.pa.ant;

public class Insect {
    protected int x;
    protected int y;
    protected Colony colony;

    Insect(Colony colony) {
        this.colony = colony;
        x = Util.randomBetween(-colony.getSize(), colony.getSize());
        y = Util.randomBetween(-colony.getSize(), colony.getSize());
    }

    protected int distanceFromOrigo() {
        return Math.abs(x) + Math.abs(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
