package com.example.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {

    private String name;
    private Integer year;
    private String nationality;

}
