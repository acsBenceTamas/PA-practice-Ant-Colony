package com.codecool.acsbencetamas.pa.ant;

public abstract class Ant extends Insect {

    Ant(Colony colony) {
        super(colony);
    }

    protected void move(int x, int y) {
        if (targetWithinBounds(this.x+x,this.y+y)) {
            this.x += x;
            this.y += y;
        }
    }

    protected void move(Cardinal cardinal) {
        move(cardinal.x, cardinal.y);
    }

    protected void moveTo(int x, int y) {
        this.x = Integer.signum(x) * Math.min(Math.abs(x),colony.getSize());
        this.y = Integer.signum(y) * Math.min(Math.abs(y),colony.getSize());
    }

    protected void moveToRandomInDistance(int distance) {
        int x = Util.randomBetween(-distance, distance);
        int y = (distance-Math.abs(x)) * Util.randomSign();
        moveTo(x,y);
    }

    protected void moveTowards(int x, int y) {
        int dx = x - this.x;
        int dy = y - this.y;
        if (Math.abs(dx) >= Math.abs(dy)) move(dx/Math.abs(dx), 0);
        else move(0, dy/Math.abs(dy));
    }

    protected void moveTowards(Insect insect) {
        moveTowards(insect.x, insect.y);
    }

    private boolean targetWithinBounds(int targetX, int targetY) {
        return Math.abs(targetX) <= colony.getSize() && Math.abs(targetY) <= colony.getSize();
    }

    abstract void handleTurn();
}
