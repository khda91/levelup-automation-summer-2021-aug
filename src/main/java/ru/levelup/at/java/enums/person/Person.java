package ru.levelup.at.java.enums.person;

public class Person {

    private String fullName;
    private Gender gender;
    private String genderString;
    private Status status;

    public Person(String fullName, Gender gender) {
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGenderString() {
        return genderString;
    }

    public void setGenderString(String genderString) {
        this.genderString = genderString;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{"
            + "fullName='" + fullName + '\''
            + ", gender=" + gender
            + ", genderString='" + genderString + '\''
            + ", status=" + (status == null ? "null" : status.getTitle())
            + '}';
    }
}
