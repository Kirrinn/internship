package org.example.seviceb.controller;

import lombok.RequiredArgsConstructor;
import org.example.seviceb.model.AuthorServiceBDto;
import org.example.seviceb.model.BookServiceBDto;
import org.example.seviceb.model.PublisherServiceBDto;
import org.example.seviceb.service.BTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceB")
@RequiredArgsConstructor
public class ControllerServiceB {

    private final BTestService testService;


    @GetMapping("/{id}")
    public ResponseEntity<AuthorServiceBDto> findAuthorById(@PathVariable("id") long id) {

       AuthorServiceBDto authorDtoAdded = testService.findAuthorById(id);
       if (authorDtoAdded != null) {
           return ResponseEntity.ok(authorDtoAdded);
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BookServiceBDto>> findBooksIBNS() {
        System.out.println("findBooksIBNS");

        return ResponseEntity.ok( testService.getAllBooksWithIbn());
    }

    @PostMapping("/addPublisher")
    public ResponseEntity<Long> addPublisherAuthor(@RequestBody PublisherServiceBDto publisherDto) {

        return ResponseEntity.ok(testService.addPublisher(publisherDto));
    }
}
