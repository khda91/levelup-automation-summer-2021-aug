package ru.levelup.at.java.statics;

public class ClassWithNonStaticField {

    String name;
    String gender;

    @Override
    public String toString() {
        return "ClassWithNonStaticField{"
            + "name='" + name + '\''
            + ", gender='" + gender + '\''
            + '}';
    }
}
