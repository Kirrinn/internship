package com.example.libraryproject.repository;

import com.example.libraryproject.entity.Author;
import com.example.libraryproject.entity.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findByNameTest(){

        Author author = Author.builder().name("Jovan")
                .birthYear(1999).nationality("India").build();
        authorRepository.save(author);

        Optional<Author> optionalAuthor = authorRepository.findByName(author.getName());

        assertTrue(optionalAuthor.isPresent());
        assertEquals(author.getName(), optionalAuthor.get().getName());
    }

    @Test
    void findByIdTest(){
        Author author = Author.builder().name("Jovan")
                .birthYear(1999).nationality("India").build();

        //vrati mi sacuvanog authora
        author = authorRepository.save(author);

        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());

        assertTrue(optionalAuthor.isPresent());
        assertEquals(author.getId(), optionalAuthor.get().getId());
    }

    @Test
    void saveAuthorTest(){

        Author author = Author.builder().name("Jovan")
                .birthYear(1999).nationality("India").build();

        Author savedAuthor = authorRepository.save(author);

        assertNotNull(savedAuthor);
        assertTrue(savedAuthor.getId() > 0);
    }
}