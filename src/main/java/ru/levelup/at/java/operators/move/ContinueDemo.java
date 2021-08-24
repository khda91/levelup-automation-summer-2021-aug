package ru.levelup.at.java.operators.move;

public class ContinueDemo {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                continue;
            }

            System.out.println("Square of " + values[i] + " is " + values[i] * values[i]);
        }
    }
}
