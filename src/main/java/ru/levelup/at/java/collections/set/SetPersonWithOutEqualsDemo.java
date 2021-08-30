package ru.levelup.at.java.collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetPersonWithOutEqualsDemo {

    public static void main(String[] args) {
        Set<PersonWithOutEquals> set = new HashSet<>();
        var nina = new PersonWithOutEquals("Nina");
        set.addAll(
            List.of(new PersonWithOutEquals("Ivan"), new PersonWithOutEquals("Marina"), new PersonWithOutEquals("Oleg"),
                new PersonWithOutEquals("Sveta"), nina));
        System.out.println("Full set -> " + set);

        set.addAll(
            List.of(new PersonWithOutEquals("Olga"), new PersonWithOutEquals("Ivan"), new PersonWithOutEquals("Oleg"),
                new PersonWithOutEquals("Sveta"), new PersonWithOutEquals("Andrey"), nina));
        System.out.println("Full set after adding new values-> " + set);
    }
}
