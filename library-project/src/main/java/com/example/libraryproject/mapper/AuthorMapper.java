package com.example.libraryproject.mapper;

import com.example.libraryproject.entity.Author;
import com.example.libraryproject.model.AuthorDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



//kazemo da je mapper i napravimo njegovu instanu
@Mapper(componentModel = "spring")
public interface AuthorMapper{

    //da dodam autora
    @Mapping(target= "birthYear", source = "year")
    Author populateAuthor(AuthorDto authorDto);

//    da popunim dto
    @Mapping(target="year", source = "birthYear")
    AuthorDto populateAuthorDto(Author author);
}
