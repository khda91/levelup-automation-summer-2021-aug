package ru.levelup.at.java.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterException1Demo {

    public static void main(String[] args) {
        PrintWriter out = null;
        //        try {
        try {
            out = new PrintWriter(new FileWriter("jju/out.txt"));
            for (int i = 0; i < 10; i++) {
                out.println("Some string");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
        //        } catch (IOException e) {
        //            System.err.println("Caught IOException: "
        //                + e.getMessage());
        //        } finally {
        //            if (out != null) {
        //                System.out.println("Closing PrintWriter");
        //                out.close();
        //            } else {
        //                System.out.println("PrintWriter not open");
        //            }
        //        }

    }
}
