package ru.levelup.at.java.enums.person;

public class EnumDemo {

    public static void main(String[] args) {
        var ivan = new Person("Ivan Ivanov", Gender.MALE);
        var marina = new Person("Marina Petrova", Gender.FEMALE);
        marina.setStatus(Status.NOT_CONFIRMED);

        System.out.println(ivan);
        System.out.println(marina);

        System.out.println();
        System.out.println();

        for (Gender value : Gender.values()) {
            System.out.println(value);
        }

        // System.out.println("Gender value of asas -> " + Gender.valueOf("asas"));     // ошибка
        // System.out.println("Gender value of female -> " + Gender.valueOf("female")); // ошибка
        System.out.println("Gender value of FEMALE -> " + Gender.valueOf("FEMALE"));

        ivan.setGenderString(GenderInterfaceConst.FEMALE);
        marina.setGenderString(GenderClassConst.FEMALE);
        ivan.setGenderString("dfhvhadfshjvbadfsjvhbjia");
    }
}
