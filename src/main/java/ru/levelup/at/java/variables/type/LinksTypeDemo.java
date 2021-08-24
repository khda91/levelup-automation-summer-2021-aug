package ru.levelup.at.java.variables.type;

public class LinksTypeDemo {

    public static void main(String[] args) {
        String newString = new String("some value 1");

        System.out.println(String.format("newString = %s", newString));

        String newString1 = newString;

        System.out.println(String.format("newString1 = %s", newString1));

        String newstring = new String("some value 1");

        // String void = "class"; -> ошибка, так нельзя называть переменные
    }
}
