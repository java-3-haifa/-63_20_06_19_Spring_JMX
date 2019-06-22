package com.telran.java3200619.controller;

public class BookDto {
    public String title;
    public String author;
    public String isbn;

    @Override
    public String toString() {
        return "BookDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
