package com.example.libraryproject.mapper;

import com.example.libraryproject.entity.Author;
import com.example.libraryproject.model.AuthorDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

//which other anotation
@ExtendWith(MockitoExtension.class)
class AuthorMapperTest {


    private final  AuthorMapper authorMapper = new AuthorMapperImpl();

    @Test
    void populateAuthor() {
        AuthorDto authorDto = AuthorDto.builder().name("test").year(1999).nationality("test").build();

        Author author = authorMapper.populateAuthor(authorDto);

        assertNotNull(author);
        assertNull(author.getId());
        assertNull(author.getBooks());
        assertEquals(authorDto.getName(), author.getName());
        assertEquals(authorDto.getNationality(), author.getNationality());
        assertEquals(authorDto.getYear(),author.getBirthYear());

    }

    @Test
    void populateAuthorDto() {

        //data
        Author author = Author.builder().name("test").birthYear(1999).nationality("test").build();


        AuthorDto authorDto = authorMapper.populateAuthorDto(author);

        assertNotNull(authorDto);
        assertEquals(authorDto.getName(), author.getName());
        assertEquals(author.getBirthYear(), authorDto.getYear());
        assertEquals(author.getNationality(), authorDto.getNationality());

    }
}