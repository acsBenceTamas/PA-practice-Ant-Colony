package com.codecool.acsbencetamas.pa.ant;

public class Drone extends Ant {

    private int matingTime = 0;

    Drone(Colony colony) {
        super(colony);
    }

    @Override
    void handleTurn() {
        if (!colony.isThereAWasp()) {
            if (matingTime <= 0) {
                workTowardsMating();
            } else {
                doMating();
            }
        }
    }

    private void workTowardsMating() {
        if (distanceFromOrigo() <= 3 ) {
            attemptMating();
        } else {
            approachQueen();
        }
    }

    private void approachQueen() {
        moveTowards(colony.getQueen());
    }

    private void attemptMating() {
        if (colony.queenIsInMood()) {
            System.out.println("  HALLELUJAH");
            matingTime = 10;
            colony.mateQueen();
        } else {
            System.out.println("  D’OH");
            moveToRandomInDistance(100);
        }
    }

    private void doMating() {
        matingTime --;
        if (matingTime <= 0) {
            moveToRandomInDistance(100);
        }
    }
}
