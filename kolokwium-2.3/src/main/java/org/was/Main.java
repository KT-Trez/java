package org.was;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Jan", "Encyklika", 2005);
        ScientificBook scientificBook = new ScientificBook("placeholder", "tmp", "whatever", 0);

        System.out.println(book);
        System.out.println(scientificBook);
    }
}