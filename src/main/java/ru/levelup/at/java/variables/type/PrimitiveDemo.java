package ru.levelup.at.java.variables.type;

public class PrimitiveDemo {

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = a + b;

        System.out.println(String.format("a (%d) + b (%d) = c (%d)", a, b, c));

        double aa;
        double bb;
        double cc;

        aa = 2.6;
        bb = 7.4;
        cc = aa + bb;

        System.out.println(String.format("aa (%f) + bb (%f) = cc (%f)", aa, bb, cc));
    }
}
