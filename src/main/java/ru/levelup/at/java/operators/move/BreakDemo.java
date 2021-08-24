package ru.levelup.at.java.operators.move;

public class BreakDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int find = 0;

        for (int i : ints) {
            if (i == 5) {
                find = i;
                break;
            }
        }

        System.out.println("Square of find element is " + (find * find));
    }
}
