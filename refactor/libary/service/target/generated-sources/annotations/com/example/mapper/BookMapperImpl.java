package com.example.mapper;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.Publisher;
import com.example.model.BookDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-09T14:24:54+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toBook(BookDto bookDto, Publisher publisher, Author author) {
        if ( bookDto == null && publisher == null && author == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        if ( bookDto != null ) {
            book.title( bookDto.getTitle() );
            book.publicationYear( bookDto.getPublicationYear() );
        }
        book.publisher( publisher );
        book.author( author );

        return book.build();
    }

    @Override
    public BookDto toBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.author( bookAuthorName( book ) );
        bookDto.publisher( bookPublisherName( book ) );
        bookDto.title( book.getTitle() );
        bookDto.publicationYear( book.getPublicationYear() );

        return bookDto.build();
    }

    private String bookAuthorName(Book book) {
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getName();
    }

    private String bookPublisherName(Book book) {
        Publisher publisher = book.getPublisher();
        if ( publisher == null ) {
            return null;
        }
        return publisher.getName();
    }
}
