package com.codecool.acsbencetamas.pa.ant;

public class Worker extends Ant {

    Worker(Colony colony) {
        super(colony);
    }

    @Override
    void handleTurn() {
        if (!colony.isThereAWasp()) {
            Cardinal direction = getRandomDirection();
            move(direction.x,direction.y);
        }
    }

    private Cardinal getRandomDirection() {
        return Cardinal.values()[Util.randomBetween(0,3)];
    }
}
