package com.example.libraryproject.mapper;

import com.example.libraryproject.entity.Author;
import com.example.libraryproject.entity.Book;
import com.example.libraryproject.entity.Publisher;
import com.example.libraryproject.model.BookDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookMapperTest {


    private final BookMapper bookMapper = new BookMapperImpl();

    @Test
    void toBook() {
        BookDto bookDto = BookDto.builder()
                .title("Kosmopolit")
                .publicationYear(2000)
                .author("Kiki Lesendric")
                .publisher("Klet").build();

        Author author = Author.builder()
                .name("Kiki Lesendric")
                .build();

        Publisher publisher = Publisher.builder()
                .name("Klet")
                .build();

        Book book = bookMapper.toBook(bookDto,publisher,author);

        assertNotNull(book);
        assertEquals(bookDto.getTitle(),book.getTitle());
        assertEquals(bookDto.getPublicationYear(),book.getPublicationYear());
        assertEquals(bookDto.getAuthor(),book.getAuthor().getName());
        assertEquals(bookDto.getPublisher(),book.getPublisher().getName());
    }

    @Test
    void toBookDto() {

        Author author = Author.builder()
                .name("Kiki Lesendric")
                .build();

        Publisher publisher = Publisher.builder()
                .name("Klet")
                .build();

        Book book = Book.builder().id(1L)
                .title("Kosmopolit")
                .publicationYear(2000)
                .author(author)
                .publisher(publisher).build();

        BookDto bookDto = bookMapper.toBookDto(book);

        assertNotNull(bookDto);
        assertEquals(book.getTitle(),bookDto.getTitle());
        assertEquals(book.getPublicationYear(),bookDto.getPublicationYear());
        assertEquals(book.getAuthor().getName(),bookDto.getAuthor());
        assertEquals(book.getPublisher().getName(),bookDto.getPublisher());

    }
}