package ru.levelup.at.java.oop.cat;

import ru.levelup.at.java.oop.Animal;
import ru.levelup.at.java.oop.Walkable;

public class Cat extends Animal implements Walkable {

    public String speed;

    public Cat(Double weight, String gender) {
        super(weight, 0, gender);
    }

    public Cat(Double weight) {
        super(weight, 0, "");
        gender = "male";
    }

    @Override
    public void walk() {
        System.out.println("Cat go for a walk");
    }

    @Override
    public void jump() {
        System.out.println("Speed jumping");
    }
}
