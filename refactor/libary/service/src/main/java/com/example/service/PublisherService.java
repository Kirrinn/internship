package com.example.service;

import com.example.entity.Publisher;
import com.example.mapper.PublisherMapper;
import com.example.model.PublisherDto;
import com.example.repository.PublisherRepository;
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
