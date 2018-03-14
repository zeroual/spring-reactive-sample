package com.zeros.springreactivesample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Story {
    @Id
    private String id;
    private String text;

    public Story(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Story{" +
            "id='" + id + '\'' +
            ", text='" + text + '\'' +
            '}';
    }
}
