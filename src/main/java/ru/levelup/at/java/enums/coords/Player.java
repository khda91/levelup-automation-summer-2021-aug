package ru.levelup.at.java.enums.coords;

public class Player {

    private final String name;
    private int xx;
    private int yy;

    public Player(String name) {
        this.name = name;
    }

    public void move(Direction direction) {
        xx += direction.getX();
        yy += direction.getY();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return xx;
    }

    public int getY() {
        return yy;
    }

    @Override
    public String toString() {
        return "Player{"
            + "xx=" + xx
            + ", yy=" + yy
            + '}';
    }
}
