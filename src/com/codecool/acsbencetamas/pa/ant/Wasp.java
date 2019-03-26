package com.codecool.acsbencetamas.pa.ant;

public class Wasp extends Insect {

    Wasp(Colony colony) {
        super(colony);
        System.out.println("Wasp spawned");
    }

    static boolean doesWaspSpawn() {
        double spawnChance = 0.02;
        return Math.random() < spawnChance;
    }

    public void kill() {
        this.colony.killWasp(this);
    }
}
