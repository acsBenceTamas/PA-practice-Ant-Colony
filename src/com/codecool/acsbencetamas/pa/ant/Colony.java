package com.codecool.acsbencetamas.pa.ant;

import java.util.ArrayList;
import java.util.List;

public class Colony {
    private int size;
    private List<Ant> ants = new ArrayList<>();
    private List<Wasp> wasps = new ArrayList<>();
    private Queen queen;

    Colony() {
        this(100);
    }

    Colony(int size) {
        this.size = size;
        initColony();
    }

    public int getSize() {
        return size;
    }

    public Queen getQueen() {
        return queen;
    }

    public void mateQueen() {
        queen.mate();
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public List<Wasp> getWasps() {
        return wasps;
    }

    public Wasp getClosestWasp(Ant ant) {
        int smallestDistance = Integer.MAX_VALUE;
        Wasp waspToReturn = null;
        for (Wasp wasp : wasps) {
            int distance = Util.getDistance(ant, wasp);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                waspToReturn = wasp;
            }
        }
        return waspToReturn;
    }

    public void killWasp(Wasp wasp) {
        wasps.remove(wasp);
    }

    private void initColony() {
        queen = new Queen(this);
        ants.add(queen);
        for (int i=0; i<Util.randomBetween(5,10); i++) {
            ants.add(new Worker(this));
        }
        for (int i=0; i<Util.randomBetween(5,10); i++) {
            ants.add(new Soldier(this));
        }
        for (int i=0; i<Util.randomBetween(5,10); i++) {
            ants.add(new Drone(this));
        }
    }

    public void simulateColony(int turns) {
        for (int i=0; i<turns; i++) {
            if (Wasp.doesWaspSpawn()) wasps.add(new Wasp(this));
            // System.out.println("Turn " + (i + 1));
            simulateTurn();
        }
    }

    private void simulateTurn() {
        for (Ant ant : ants) {
            ant.handleTurn();
        }
    }

    public boolean isThereAWasp() {
        return !wasps.isEmpty();
    }

    public boolean queenIsInMood() {
        return queen.isInMood();
    }
}
