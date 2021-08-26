package ru.levelup.at.java.oop;

public abstract class Animal {

    private Double weight;
    Integer age;
    protected String gender;

    protected Animal() {
    }

    protected Animal(Double weight, Integer age, String gender) {
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void say() {
        System.out.println("Animal say ha-ha");
    }

    public abstract void jump();

    @Override
    public String toString() {
        return "Animal{"
            + "weight=" + weight
            + ", age=" + age
            + ", gender='" + gender + '\''
            + '}';
    }
}
