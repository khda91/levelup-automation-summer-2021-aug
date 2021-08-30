package ru.levelup.at.java.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("volodya");
        set.addAll(List.of("ivan", "marya"));

        System.out.println("Full set -> " + set);

        System.out.println("Get element");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("add more values");
        set.addAll(List.of("babushka", "ivan", "roma", "valka", "mama"));
        System.out.println("Full set after adding new values-> " + set);
    }
}
