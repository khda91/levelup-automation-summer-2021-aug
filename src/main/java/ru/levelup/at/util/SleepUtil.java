package ru.levelup.at.util;

public class SleepUtil {

    public static void sleep(long sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
