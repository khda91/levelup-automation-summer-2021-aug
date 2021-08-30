package ru.levelup.at.java.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Ivan", "Marya");
        map.put("Sveta", "Vova");
        map.put("Oleg", "Veronika");
        map.put("Polina", "Misha");

        System.out.println("Value in map by key Sveta is " + map.get("Sveta"));

        System.out.println();
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }


        map.put("Oleg", "Nina");
        System.out.println();
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }

        Integer integer = Integer.parseInt("150");
        map.put(integer.toString(), integer.toString());
    }
}
