package ru.levelup.at.java.oop;

import ru.levelup.at.java.oop.cat.Cat;

public class Demo {

    public static void main(String[] args) {
        // Animal animal = new Animal(28.7D, 10, "female");
        // System.out.println("animal -> " + animal);

        // animal.weight = 25.3;
        // animal.age = 11;
        // System.out.println("animal -> " + animal);

        Dog bobik = new Dog();
        bobik.setNick("Bobik");
        bobik.setGender("male");
        bobik.setWeight(10.0D);
        bobik.setBreed("Shpich");
        bobik.age = 5;
        bobik.gender = "netural";

        // animal.say();
        bobik.say();

        Cat speedy = new Cat(5.25D);
        speedy.speed = "very fast"; // так писать нельзя

        bobik.walk();
    }
}
