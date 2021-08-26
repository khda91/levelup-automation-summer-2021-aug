package ru.levelup.at.java.statics;

public class Demo {

    public static void main(String[] args) {
        System.out.println("ClassWithNonStaticField");

        ClassWithNonStaticField vasya = new ClassWithNonStaticField();
        vasya.name = "vasya";
        vasya.gender = "male";
        System.out.println(vasya);

        var masha = new ClassWithNonStaticField();
        masha.name = "Masha";
        masha.gender = "female";
        System.out.println(masha);

        System.out.println();
        System.out.println("ClassWithStaticField");

        var lena = new ClassWithStaticField();
        lena.name = "Lena";
        lena.gender = "female";
        System.out.println(lena);
        System.out.println(ClassWithStaticField.status);

        var kostya = new ClassWithStaticField();
        kostya.name = "Kostya";
        kostya.gender = "male";
        System.out.println(kostya);
        System.out.println(kostya.status);

        kostya.status = "SILVER";
        System.out.println();

        System.out.println("Lena status -> " + lena.status);
    }
}
