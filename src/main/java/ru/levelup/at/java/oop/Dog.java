package ru.levelup.at.java.oop;

import java.io.Serializable;

public class Dog extends Animal implements Walkable, Serializable {

    private String nick;
    private String breed;
    private Integer height;
    private Integer length;

    public Dog() {
        this("Dotty");
        age = 0;
        gender = "female";
    }

    public Dog(String nick) {
        this.nick = nick;
        // super.weight = 25.6;
    }

    public Dog(String nick, String breed, Integer height, Integer length, Double weight, Integer age, String gender) {
        super(weight, age, gender);
        this.nick = nick;
        this.breed = breed;
        this.height = height;
        this.length = length;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public void say() {
        System.out.println("Dog sat Haw-Haw");
    }

    @Override
    public void jump() {
        System.out.println("jump-jump");
    }

    @Override
    public String toString() {
        return "Dog{"
            + "nick='" + nick + '\''
            + ", breed='" + breed + '\''
            + ", height=" + height
            + ", length=" + length
            + '}';
    }

    @Override
    public void walk() {
        System.out.println("Go for a walk");
    }
}
