package com.codecool.acsbencetamas.pa.ant;

public class Queen extends Ant {

    private int timeToMood;

    Queen(Colony colony) {
        super(colony);
        x = 0;
        y = 0;
        setMood();
    }

    @Override
    void handleTurn() {
        if (timeToMood > 0) timeToMood--;
    }

    void mate() {
        setMood();
    }

    private void setMood() {
        timeToMood = Util.randomBetween(100,200);
    }

    public boolean isInMood() {
        return (timeToMood <= 0);
    }
}
