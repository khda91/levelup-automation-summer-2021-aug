package ru.levelup.at.java.exceptions;

public class ExceptionInitialDemo {

    public static void main(String[] args) {
        check("15");
        check("-15");
        check("15.0");
    }

    static void check(String s) {
        Integer a = Integer.parseInt(s);
        System.out.println(a);
    }
}
