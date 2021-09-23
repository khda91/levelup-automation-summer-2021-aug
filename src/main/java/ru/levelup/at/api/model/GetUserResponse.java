package ru.levelup.at.api.model;

import java.util.Objects;

public class GetUserResponse {

    private UserData data;
    private SupportData support;

    public GetUserResponse() {
    }

    public GetUserResponse(UserData data, SupportData support) {
        this.data = data;
        this.support = support;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public SupportData getSupport() {
        return support;
    }

    public void setSupport(SupportData support) {
        this.support = support;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetUserResponse that = (GetUserResponse) o;
        return Objects.equals(data, that.data) && Objects.equals(support, that.support);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, support);
    }

    @Override
    public String toString() {
        return "GetUserResponse{"
            + "data=" + data
            + ", support=" + support
            + '}';
    }
}
