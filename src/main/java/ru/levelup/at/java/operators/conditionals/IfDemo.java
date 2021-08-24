package ru.levelup.at.java.operators.conditionals;

import java.util.Arrays;

public class IfDemo {

    public static void main(String[] args) {
        System.out.println("If-Then Demo");
        ifThenDemo();

        System.out.println();
        System.out.println();

        System.out.println("If-Then-Else Demo");
        ifThenElseDemo();

        System.out.println();
        System.out.println();

        System.out.println("If-Then-Else multiple Demo");
        ifThenElseMultipleDemo();

        System.out.println();
        System.out.println();
    }

    static void ifThenElseMultipleDemo() {
        int[] testScores = {91, 50, 68, 45, 70, 85};

        for (int testScore : testScores) {
            char grade = '\u0000';
            if (testScore >= 90) {
                grade = 'A';
            } else if (testScore >= 80) {
                grade = 'B';
            } else if (testScore >= 70) {
                grade = 'C';
            } else if (testScore >= 60) {
                grade = 'D';
            } else if (testScore >= 50) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            System.out.println(String.format("Mark %s get for test score %d", grade, testScore));
        }
    }

    static void ifThenElseDemo() {
        String[] array = {"son", "dog", "mama", "sun", "papa", "sushi", "shape", "cat"};

        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("s")) {
                array[i] = array[i].replaceAll("s", "");
            } else {
                array[i] = array[i] + "s";
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    static void ifThenDemo() {
        String[] array = {"son", "dog", "mama", "sun", "papa", "sushi", "shape", "cat"};

        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("s")) {
                array[i] = array[i].replaceAll("s", "");
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
