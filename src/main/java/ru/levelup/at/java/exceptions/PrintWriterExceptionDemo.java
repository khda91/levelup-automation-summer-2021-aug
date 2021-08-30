package ru.levelup.at.java.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExceptionDemo {

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("jju/out.txt"));
            for (int i = 0; i < 10; i++) {
                out.println("Some string");
            }
        } catch (IOException e) {
            System.err.println("Caught IOException: "
                + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }

    }
}
