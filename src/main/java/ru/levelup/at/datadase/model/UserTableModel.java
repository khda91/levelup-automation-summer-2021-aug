package ru.levelup.at.datadase.model;

import java.util.Objects;

public class UserTableModel {

    private Long id;
    private String name;
    private String email;

    public UserTableModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTableModel that = (UserTableModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
            && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "UserTableModel{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", email='" + email + '\''
            + '}';
    }
}
