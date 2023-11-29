package com.BookWave.springbootlibrary.controller;

import com.BookWave.springbootlibrary.entity.Book;
import com.BookWave.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookservice) {
        this.bookService = bookservice;
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook (@RequestParam Long bookId) throws Exception {
        String userEmail = "sijoyalmeida@gmail.com";
        return bookService.checkoutBook(userEmail, bookId);
    }

}
