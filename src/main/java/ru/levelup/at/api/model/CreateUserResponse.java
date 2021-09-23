package ru.levelup.at.api.model;

import java.util.Objects;

public class CreateUserResponse {

    private String id;
    private String name;
    private String job;
    private String createdAt;

    public CreateUserResponse() {
    }

    public CreateUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateUserResponse that = (CreateUserResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
            && Objects.equals(job, that.job) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, job, createdAt);
    }

    @Override
    public String toString() {
        return "CreateUserResponse{"
            + "id='" + id + '\''
            + ", name='" + name + '\''
            + ", job='" + job + '\''
            + ", createdAt='" + createdAt + '\''
            + '}';
    }
}
