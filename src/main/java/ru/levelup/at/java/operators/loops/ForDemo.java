package ru.levelup.at.java.operators.loops;

public class ForDemo {

    public static void main(String[] args) {
        System.out.println("For Demo");
        forDemo();

        System.out.println();
        System.out.println();

        System.out.println("ForEach Demo");
        forEachDemo();

        System.out.println();
        System.out.println();
    }

    static void forDemo() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Count is: " + i);
        }
    }

    static void forEachDemo() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int item : numbers) {
            System.out.println("Count is: " + item);
        }

    }
}
