package ru.levelup.at.design.patterns.builder;

public class User {

    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;

    public User(String firstName, String lastName, Integer age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{"
            + "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", age=" + age
            + ", gender='" + gender + '\''
            + '}';
    }

    public static class UserBuilder {

        private String firstName;
        private String lastName;
        private Integer age;
        private String gender;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(this.firstName, this.lastName, this.age, this.gender);
        }
    }
}
