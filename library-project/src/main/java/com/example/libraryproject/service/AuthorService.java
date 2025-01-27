package com.example.libraryproject.service;


import com.example.libraryproject.entity.Author;
import com.example.libraryproject.mapper.AuthorMapper;
import com.example.libraryproject.model.AuthorDto;
import com.example.libraryproject.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    public ResponseEntity<AuthorDto> getAuthorById(long id){

        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent()){

            Author authorEntity = author.get();
            AuthorDto authorDto = authorMapper.populateAuthorDto(authorEntity);
//            AuthorDto authorDto = new AuthorDto(
//                    authorEntity.getName(), authorEntity.getBirthYear(),authorEntity.getNationality());
            return  ResponseEntity.ok(authorDto);
             }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    
    public ResponseEntity<Long> addAuthor(AuthorDto authorDto){


        Author author = authorMapper.populateAuthor(authorDto);
        //Author author = new Author(
          //      null, authorDto.getName() ,authorDto.getBirthYear(),authorDto.getNationality(),null);
        return ResponseEntity.ok().body(authorRepository.save(author).getId());
    }

 
    public ResponseEntity<HttpStatus> updateAuthor(Long id, String nationality){

        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent()){

            Author author1 = new Author(author.get().getId(),author.get().getName(),
                    author.get().getBirthYear(),author.get().getNationality(),null);


            author1.setNationality(nationality);
            authorRepository.save(author1);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
