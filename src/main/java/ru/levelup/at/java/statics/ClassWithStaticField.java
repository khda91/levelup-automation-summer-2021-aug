package ru.levelup.at.java.statics;

public class ClassWithStaticField {

    static String status = "GOLD";

    String name;
    String gender;

    @Override
    public String toString() {
        return "ClassWithStaticField{"
            + "name='" + name + '\''
            + ", gender='" + gender + '\''
            + '}';
    }
}
