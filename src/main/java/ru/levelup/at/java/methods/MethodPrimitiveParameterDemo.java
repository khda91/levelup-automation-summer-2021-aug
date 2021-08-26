package ru.levelup.at.java.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MethodPrimitiveParameterDemo {

    public static void main(String[] args) {
        int x = 3;
        System.out.println("x = " + x);
        plusTwo(x);
        System.out.println("x = " + x);

        System.out.println();
        System.out.println();

        List<String> xx = new ArrayList<>();
        xx.add("abc");
        xx.add("cba");
        xx.add("bac");
        System.out.println("xx = " + xx);
        plusTwo1(xx);
        System.out.println("xx = " + xx);
        plusTwo2(xx);
        System.out.println("xx = " + xx);
    }

    static void plusTwo(int x) {
        x = x + 2;
    }

    static void plusTwo1(List<String> xx) {
        xx.add("jjj");
    }

    static void plusTwo2(List<String> xx) {
        List<String> xxx = new ArrayList<>(xx);
        xxx.add("jjj");
    }

}
