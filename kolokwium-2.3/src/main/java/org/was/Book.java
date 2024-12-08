package org.was;

public class Book {
    public final String author;
    public final String title;
    public final int yearPublished;


    public Book(String author, String title, int yearPublished) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public String toString() {
        return "Title: " + this.title + ", Author: " + this.author + ", Year Published: " + this.yearPublished;
    }
}
