package ru.levelup.at.java.operators.loops;

public class WhileDemo {

    public static void main(String[] args) {
        System.out.println("While Demo");
        whileDemo();

        System.out.println();
        System.out.println();

        System.out.println("Do-While Demo");
        doWhileDemo();

        System.out.println();
        System.out.println();
    }

    static void infinityDemo() {
        int count = 0;

        // бесконечный цикл
        while (true) {
            System.out.println(count);
            count++; // count = count + 1;
        }
    }

    static void doWhileDemo() {
        int count = 10;

        do {
            System.out.println(count);
            count++; // count = count + 1;
        } while (count < 10);
    }

    static void whileDemo() {
        int count = 10;

        while (count < 10) {
            System.out.println(count);
            count++; // count = count + 1;
        }
    }
}
