package ru.levelup.at.java.variables.type;

public class ArraysDemo {

    public static void main(String[] args) {
        System.out.println("Single array");
        singleArray();

        System.out.println();
        System.out.println();

        System.out.println("Double array (Matrix)");
        matrixArray();

        System.out.println();
        System.out.println();
    }

    static void matrixArray() {
        String[][] matrix = new String[2][2];
        matrix[0][0] = "mama";
        matrix[1][1] = "papa";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void singleArray() {
        int[] values = new int[10];
        System.out.println("values array size is " + values.length);
        System.out.println();

        for (int i = 0; i < values.length; i++) {
            values[i] = (i + 1) * (int) ((Math.random() + 1) * 100);
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        values[5] = 10;
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}

