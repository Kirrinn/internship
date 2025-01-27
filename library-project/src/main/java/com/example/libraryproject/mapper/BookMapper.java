package com.example.libraryproject.mapper;

import com.example.libraryproject.entity.Author;
import com.example.libraryproject.entity.Book;
import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.model.BookDto;
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

