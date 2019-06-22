package com.telran.java3200619.repository;

import com.telran.java3200619.controller.BookDto;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@ManagedResource(description = "Test MBean")
public class BookRepositoryImpl implements BookRepository {
    private ConcurrentHashMap<String,BookDto> map = new ConcurrentHashMap<>();
    private String fileName = "default.txt";
    @Override
    public boolean add(BookDto book) {
        return map.putIfAbsent(book.isbn,book) == null;
    }

    @ManagedAttribute(description = "Set file name")
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    @ManagedAttribute(description = "Get file name")
    public String getFileName(){
        return fileName;
    }

    @ManagedOperation
    public int size(){
        return map.size();
    }

    @ManagedOperation
    @ManagedOperationParameters({
           @ManagedOperationParameter(name="isbn",description = "International serial book number")
    })
    public String bookByIsbn(String isbn){
        return Objects.toString(map.get(isbn));
    }
}
