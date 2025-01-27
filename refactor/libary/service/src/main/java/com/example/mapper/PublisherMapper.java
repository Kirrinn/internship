package com.example.mapper;


import com.example.entity.Publisher;
import com.example.model.PublisherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toPublisher(PublisherDto publisherDto);


}
