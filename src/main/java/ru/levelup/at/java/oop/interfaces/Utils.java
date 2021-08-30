package ru.levelup.at.java.oop.interfaces;

import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static List<String> createList() {
        return new LinkedList<>(List.of("mama", "papa"));
    }
}
