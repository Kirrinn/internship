package com.example.mapper;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.Publisher;
import com.example.model.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.WARN)

public interface BookMapper {

    //pitaj kako kompleksnije mapiranje da odradis
//    @Mapping(target = "author", source = "author")
//    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "id", ignore = true)
    Book toBook(BookDto bookDto, Publisher publisher, Author author);

    //ako nisu ista imena
    @Mapping(target = "author", source = "author.name")
    @Mapping(target = "publisher", source = "publisher.name")
    BookDto toBookDto(Book book);
}

