package ru.levelup.at.java.oop.interfaces;

import java.util.List;

public class InterfaceDemo {

    public static void main(String[] args) {
        List<String> list = Utils.createList();
        list.add("baba");

        System.out.println(list);
    }
}
