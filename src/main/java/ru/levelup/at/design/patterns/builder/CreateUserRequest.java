package ru.levelup.at.design.patterns.builder;

public class CreateUserRequest {

    private String name;
    private String job;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CreateUserRequest{"
            + "name='" + name + '\''
            + ", job='" + job + '\''
            + '}';
    }

    public static class Builder {

        private String name;
        private String job;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this.name, this.job);
        }
    }
}
