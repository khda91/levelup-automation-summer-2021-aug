package ru.levelup.at.java.enums.person;

public enum Status {

    ACTIVE("Active"),
    ONLINE("Online"),
    OFFLINE("Offline"),
    NOT_CONFIRMED("Not confirmed");

    String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
