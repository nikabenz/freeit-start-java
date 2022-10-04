package edu.freeit.lesson16.example.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksList;

    public Library() {
        booksList = new ArrayList<>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public void print() {
        booksList.forEach(book -> System.out.println(book));
    }
}
