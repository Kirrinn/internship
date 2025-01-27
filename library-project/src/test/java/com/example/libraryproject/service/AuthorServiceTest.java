package com.example.libraryproject.service;

import com.example.libraryproject.entity.Author;

import com.example.libraryproject.mapper.AuthorMapper;
import com.example.libraryproject.model.AuthorDto;

import com.example.libraryproject.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private AuthorMapper authorMapper;
    @InjectMocks
    private AuthorService authorService;


    @Test
    void getAuthorById() {

        //DATA PREPARATION
        Long id = 1L;
       Author author = new Author(id,"Test",1999,"Serbian",null);
       AuthorDto authorDto = new AuthorDto("Test",1999,"Serbian");

       //mocking
        when(authorMapper.populateAuthorDto(author)).thenReturn(authorDto);
        when(authorRepository.findById(id)).thenReturn(Optional.of(author));

        //respond
        ResponseEntity<AuthorDto> response = authorService.getAuthorById(id);

        verify(authorMapper).populateAuthorDto(author);
        verify(authorRepository).findById(id);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotNull(response);
        assertEquals(author.getName(),response.getBody().getName());
        assertEquals(author.getBirthYear(), response.getBody().getYear());
        assertEquals(author.getNationality(), response.getBody().getNationality());
    }

    @Test
    void addAuthorSuccess() {
        Author author = new Author(1L,"Test",1999,"Serbian",null);
        AuthorDto authorDto = new AuthorDto("Test",1999,"Serbian");

        when(authorMapper.populateAuthor(authorDto)).thenReturn(author);
        when(authorRepository.save(author)).thenReturn(author);

        //poziv
        ResponseEntity<Long> response = authorService.addAuthor(authorDto);

        verify(authorMapper).populateAuthor(authorDto);
        verify(authorRepository).save(author);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(1L,response.getBody( ));

    }


    @Test
   // @MockitoSettings(strictness = Strictness.LENIENT) //if the instance of the object changes
    void updateAuthor() {
        //data
        String oldNationality = "Serbian";
        String newNationality = "New Serbian";
        Long id = 1L;
        Author author = new Author(id,"Test",1999,oldNationality,null);

        when(authorRepository.findById(id)).thenReturn(Optional.of(author));
        //
        //after he updates this he makes a new instance and he cant link it because it is not
        //a same object strict couple then we will use other method for no strict stubing
        //when(authorRepository.save(author)).thenReturn(author);Mockito, in strict mode,
        // tries to match the argument passed to save() with the one it has previously stubbed.
        // Since the reference to the author object changes after it is updated, Mockito detects
        // a mismatch between the two references (com.example.libraryproject.entity.Author@3d28c0af
        // vs com.example.libraryproject.entity.Author@529a2d6f), even though the fields are identical
        // apart from the nationality change.
        // Use doReturn().when() instead of when().thenReturn() to avoid strict stubbing

        doReturn(author).when(authorRepository).save(any(Author.class));  // Do not use the specific 'author' object here.


        ResponseEntity<HttpStatus> response= authorService.updateAuthor(id,newNationality);

        // Capture the argument passed to save
        ArgumentCaptor<Author> authorCaptor = ArgumentCaptor.forClass(Author.class);


        verify(authorRepository).save(authorCaptor.capture());
        verify(authorRepository).findById(id);


        Author savedAuthor = authorCaptor.getValue();

       // verify(authorRepository).save(authorCaptor.capture());
      //  verify(authorRepository).save(any(Author.class));

        //how he knows that this is changed ?
        assertEquals(newNationality,savedAuthor.getNationality());
        assertEquals(HttpStatus.ACCEPTED,response.getStatusCode());
    }
}