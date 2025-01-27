package com.example.libraryproject.mapper;


import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.model.PublisherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toPublisher(PublisherDto publisherDto);


}
