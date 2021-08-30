package ru.levelup.at.java.oop;

public interface Walkable {

    void walk();

    // boolean didItWork(int i, double x, String s);

    default void walk(String name) {
        System.out.println(name + " go for a walk");
    }
}
