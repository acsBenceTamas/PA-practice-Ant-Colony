package com.codecool.acsbencetamas.pa.ant;

public class Soldier extends Ant {

    private int direction;

    Soldier(Colony colony) {
        super(colony);
        direction = Util.randomBetween(0,3);
    }

    @Override
    void handleTurn() {
        if (colony.isThereAWasp()) {
            pursueWasps();
        } else {
            patrol();
        }
    }

    private Wasp getClosestWasp() {
        return colony.getClosestWasp(this);
    }

    private void pursueWasps() {
        Wasp closestWasp = getClosestWasp();
        if (Util.getDistance(this, closestWasp) == 0) {
            closestWasp.kill();
            System.out.println("HAJIME");
        }
        else moveTowards(closestWasp);
    }

    private void patrol() {
        Cardinal cardinal = Cardinal.values()[direction];
        move(cardinal);
        direction = (direction + 1)%4;
    }
}
