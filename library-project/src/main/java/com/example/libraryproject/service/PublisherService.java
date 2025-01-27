package com.example.libraryproject.service;

import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.mapper.PublisherMapper;
import com.example.libraryproject.model.PublisherDto;
import com.example.libraryproject.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public ResponseEntity<Long> addPublisher(PublisherDto publisherDto) {

        Publisher publisher = publisherMapper.toPublisher(publisherDto);
        //Publisher publisher = new Publisher(null,publisherDto.getName(),publisherDto.getCountry(),null);
        return ResponseEntity.ok(publisherRepository.save(publisher).getId());
    }
}
