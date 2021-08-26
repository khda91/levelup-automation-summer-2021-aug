package ru.levelup.at.java.oop;

public abstract class Fish extends Animal {

    private Integer length;
    private String color;
    private String type;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fish{"
            + "length=" + length
            + ", color='" + color + '\''
            + ", type='" + type + '\''
            + '}';
    }
}
