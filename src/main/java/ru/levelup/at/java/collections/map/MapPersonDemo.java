package ru.levelup.at.java.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapPersonDemo {

    public static void main(String[] args) {
        Map<Person, Person> map = new HashMap<>();
        map.put(new Person("Ivan"), new Person("Marya"));
        map.put(new Person("Sveta"), new Person("Vova"));
        map.put(new Person("Oleg"), new Person("Veronika"));
        map.put(new Person("Polina"), new Person("Misha"));

        System.out.println("Value in map by key Sveta is " + map.get(new Person("Sveta")));

        System.out.println();
        for (Entry<Person, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }


        System.out.println();
        map.put(new Person("Oleg"), new Person("Nina"));
        for (Entry<Person, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }
    }
}
