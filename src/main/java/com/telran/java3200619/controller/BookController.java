package com.telran.java3200619.controller;

import com.telran.java3200619.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class BookController {
    BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }


    @PostMapping("book")
    public void addBook(@RequestBody BookDto book){
        repository.add(book);
    }
}
