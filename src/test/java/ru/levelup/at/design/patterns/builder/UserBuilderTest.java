package ru.levelup.at.design.patterns.builder;

import org.testng.annotations.Test;

public class UserBuilderTest {

    @Test
    public void testBuilderSimple() {
        User user = User.builder().setFirstName("Kolya")
                         .setLastName("Vasiliev")
                         .setAge(18)
                         .setGender("MALE")
                         .build();
        System.out.println(user);
        System.out.println();

        User vasya = User.builder().setFirstName("Vasya")
                        .setLastName("Ivanov")
                        .build();

        System.out.println(vasya);
        System.out.println();
    }
}
