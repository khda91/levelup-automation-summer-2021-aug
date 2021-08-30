package ru.levelup.at.java.collections.set;

public class PersonWithOutEquals {

    private final String name;

    public PersonWithOutEquals(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{"
            + "name='" + name + '\''
            + '}';
    }
}
