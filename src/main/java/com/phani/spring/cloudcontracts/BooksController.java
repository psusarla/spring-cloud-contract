package com.phani.spring.cloudcontracts;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class BooksController {
    Map<Integer, Book> bookMap = new HashMap<>();

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookMap.get(id);
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody Book book) {
        bookMap.put(book.getId(), book);
    }

}
