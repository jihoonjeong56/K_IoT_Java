package org.example.chapter13.practice.model;

import lombok.Getter;

@Getter
public class NonFiction extends Book {
    private String field; // it, 수험서, 언어 등등

    public NonFiction(String id, String title, String author, String field) {
        super(id, title, author);
        this.field = field;
    }

    @Override
    public String toString() {
        return super.toString() + ", Field: " + field;
    }
}
