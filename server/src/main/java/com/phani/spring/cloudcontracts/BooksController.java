package com.phani.spring.cloudcontracts;

import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BooksController {
    Map<Integer, Book> bookMap = new HashMap<>();
    int counter = 0;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) {
        return bookMap.get(id);
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        book.setId(++counter);
        bookMap.put(book.getId(), book);
        return book;
    }

    @PostConstruct
    public void init() {
        saveBook(Book.builder().name("The Hunger Games").author("Suzanne Collins").build());
        saveBook(Book.builder().name("To Kill a Mockingbird").author("Harper Lee").build());
        saveBook(Book.builder().name("Harry Potter and the Order of the Phoenix").author("J.K. Rowling").build());
    }
}
