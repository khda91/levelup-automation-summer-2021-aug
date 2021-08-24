package ru.levelup.at.java.consturctors;

public class Point {

    double xx;
    double yy;

    public Point() {
    }

    public Point(double xx) {
        this(xx, 0.0);
    }

    public Point(double xx, double yy) {
        this.xx = xx;
        this.yy = yy;
    }
}
