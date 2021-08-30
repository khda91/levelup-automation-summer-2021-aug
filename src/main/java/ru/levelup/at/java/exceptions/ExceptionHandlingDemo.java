package ru.levelup.at.java.exceptions;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        check("15");
        check("-15");
        check("15.0");
        check("19");
        check("jsvhdasbvhjds");
        check("85");
        check(null);
        check("84");
    }

    static void check(String s) {
        if (s != null) {
            try {
                Integer a = Integer.parseInt(s);
                System.out.println(a);
            } catch (NumberFormatException e) {
                System.err.println(s + " is not an integer value");
            }
        }
    }
}
