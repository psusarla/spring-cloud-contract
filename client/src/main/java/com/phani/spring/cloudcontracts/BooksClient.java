package com.phani.spring.cloudcontracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BooksClient {

    public Book getBook(int bookId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<Book> responseEntity = restTemplate.exchange(
                "http://localhost:8090/book/" + bookId,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                Book.class);

        Book book = responseEntity.getBody();
        return book;
    }

    public Book createBook(Book book) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        HttpEntity<Book> request = new HttpEntity<>(book);
        ResponseEntity<Book> responseEntity = restTemplate.exchange(
                "http://localhost:8090/book",
                HttpMethod.POST,
                request, Book.class);

        return responseEntity.getBody();

    }
}
