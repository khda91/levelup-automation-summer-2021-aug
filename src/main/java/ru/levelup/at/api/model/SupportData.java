package ru.levelup.at.api.model;

import java.util.Objects;

public class SupportData {

    private String url;
    private String text;

    public SupportData() {
    }

    public SupportData(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupportData that = (SupportData) o;
        return Objects.equals(url, that.url) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, text);
    }

    @Override
    public String toString() {
        return "SupportData{"
            + "url='" + url + '\''
            + ", text='" + text + '\''
            + '}';
    }
}
