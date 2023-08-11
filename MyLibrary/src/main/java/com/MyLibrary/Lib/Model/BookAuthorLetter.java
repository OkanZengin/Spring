package com.MyLibrary.Lib.Model;

import java.util.List;

public class BookAuthorLetter {
    private String letter;
    private List<Book> books;
    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLetter() {
        return letter;
    }

    public List<Book> getBooks() {
        return books;
    }
}
