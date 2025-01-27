package com.example.libraryproject.controller;


import com.example.libraryproject.model.AuthorDto;
import com.example.libraryproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findAuthorById(@PathVariable("id") long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public ResponseEntity<Long> addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }

    //@Validate
    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> updateAuthor(@PathVariable("id") long id, @RequestBody AuthorDto authorDto){
        return authorService.updateAuthor(id, authorDto.getNationality());
    }

}

