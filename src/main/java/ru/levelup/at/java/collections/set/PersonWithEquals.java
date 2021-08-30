package ru.levelup.at.java.collections.set;

import java.util.Objects;

public class PersonWithEquals {

    private final String name;

    public PersonWithEquals(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonWithEquals that = (PersonWithEquals) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{"
            + "name='" + name + '\''
            + '}';
    }
}
