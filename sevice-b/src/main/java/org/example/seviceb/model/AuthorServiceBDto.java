package org.example.seviceb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorServiceBDto {
    private String name;
    private Integer year;
    private String nationality;
    private String biography;


}
