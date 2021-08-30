package ru.levelup.at.java.enums.coords;

public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);
    private final int xx;
    private final int yy;

    Direction(int x, int y) {
        this.xx = x;
        this.yy = y;
    }

    public int getX() {
        return xx;
    }

    public int getY() {
        return yy;
    }
}
