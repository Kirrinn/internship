package com.example.mapper;

import com.example.entity.Author;
import com.example.model.AuthorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-09T14:24:54+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author populateAuthor(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author.AuthorBuilder author = Author.builder();

        author.birthYear( authorDto.getYear() );
        author.name( authorDto.getName() );
        author.nationality( authorDto.getNationality() );

        return author.build();
    }

    @Override
    public AuthorDto populateAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setYear( author.getBirthYear() );
        authorDto.setName( author.getName() );
        authorDto.setNationality( author.getNationality() );

        return authorDto;
    }
}
