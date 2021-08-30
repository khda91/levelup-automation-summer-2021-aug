package ru.levelup.at.java.collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetPersonWithEqualsDemo {

    public static void main(String[] args) {
        Set<PersonWithEquals> set = new HashSet<>();
        var nina = new PersonWithEquals("Nina");
        set.addAll(List.of(new PersonWithEquals("Ivan"), new PersonWithEquals("Marina"), new PersonWithEquals("Oleg"),
            new PersonWithEquals("Sveta"), nina));
        System.out.println("Full set -> " + set);

        set.addAll(List.of(new PersonWithEquals("Olga"), new PersonWithEquals("Ivan"), new PersonWithEquals("Oleg"),
            new PersonWithEquals("Sveta"), new PersonWithEquals("Andrey"), nina));
        System.out.println("Full set after adding new values-> " + set);
    }
}
