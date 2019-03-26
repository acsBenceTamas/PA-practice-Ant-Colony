package com.codecool.acsbencetamas.pa.ant;

public enum Cardinal {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);

    int x;
    int y;

    Cardinal(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
