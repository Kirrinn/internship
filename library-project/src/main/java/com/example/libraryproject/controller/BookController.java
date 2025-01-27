package com.example.libraryproject.controller;


import com.example.libraryproject.entity.Book;
import com.example.libraryproject.model.BookDto;
import com.example.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long id){
        return  bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

}
