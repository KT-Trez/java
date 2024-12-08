package org.was;

public class ScientificBook extends Book {
    public final String field;

    public ScientificBook(String field, String author, String title, int yearPublished) {
        super(author, title, yearPublished);

        this.field = field;
    }

    @Override
    public String toString() {
        return "Field: " + this.field + ", Title: " + this.title + ", Author: " + this.author + ", Year Published: " + this.yearPublished;
    }
}
