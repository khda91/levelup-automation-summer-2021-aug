package ru.levelup.at.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class UserData {

    private Long id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserData userData = (UserData) o;
        return Objects.equals(id, userData.id) && Objects.equals(email, userData.email)
            && Objects.equals(firstName, userData.firstName) && Objects.equals(lastName,
            userData.lastName) && Objects.equals(avatar, userData.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, avatar);
    }

    @Override
    public String toString() {
        return "UserData{"
            + "id=" + id
            + ", email='" + email + '\''
            + ", firstName='" + firstName
            + '\'' + ", lastName='" + lastName + '\''
            + ", avatar='" + avatar + '\''
            + '}';
    }
}
