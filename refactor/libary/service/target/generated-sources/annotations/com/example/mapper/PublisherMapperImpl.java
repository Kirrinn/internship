package com.example.mapper;

import com.example.entity.Publisher;
import com.example.model.PublisherDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-09T14:24:54+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public Publisher toPublisher(PublisherDto publisherDto) {
        if ( publisherDto == null ) {
            return null;
        }

        Publisher.PublisherBuilder publisher = Publisher.builder();

        publisher.name( publisherDto.getName() );
        publisher.country( publisherDto.getCountry() );

        return publisher.build();
    }
}
