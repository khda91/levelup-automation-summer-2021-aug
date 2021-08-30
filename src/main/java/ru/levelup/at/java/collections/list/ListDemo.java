package ru.levelup.at.java.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("mama");
        list.add("papa");
        list.add("baba");
        list.addAll(List.of("ivan", "method", "volodya", "cat"));

        System.out.println("full list content ->" + list);
        System.out.println("Get 0 index element -> " + list.get(0));
        System.out.println("Get 4 index element -> " + list.get(4));
        System.out.println("Get cat element -> " + list.get(list.indexOf("cat")));

        list.add(5, "index 5");
        System.out.println("full list content ->" + list);

        list.set(6, "valka");
        System.out.println("full list content ->" + list);

        list.remove(6);
        list.remove("cat");
        System.out.println("full list content ->" + list);

        List<String> linkedList = new LinkedList<>();
        linkedList.addAll(list);

        linkedList.get(5);
    }
}
