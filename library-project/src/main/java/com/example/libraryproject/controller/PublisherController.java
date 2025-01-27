package com.example.libraryproject.controller;


import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.model.PublisherDto;
import com.example.libraryproject.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/publishers")
@RequiredArgsConstructor

public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Long> addPublisher(@RequestBody  PublisherDto publisherDto) {

        return publisherService.addPublisher(publisherDto);
    }
}
