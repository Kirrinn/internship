package com.example.libraryproject.mapper;

import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.model.PublisherDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PublisherMapperTest {


    private final PublisherMapper mapper = new PublisherMapperImpl();


    @Test
    void toPublisher() {
        PublisherDto publisherDto = PublisherDto.builder()
                .name("Test Publisher")
                .country("Test Country")
                .build();

        Publisher publisher = mapper.toPublisher(publisherDto);

        assertNotNull(publisher);
        assertNull(publisher.getId());
        assertNull(publisher.getBooks());
        assertEquals("Test Publisher", publisher.getName());
        assertEquals("Test Country", publisher.getCountry());
    }
}