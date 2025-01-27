package com.example.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookDto {
    private String title;
    private Integer publicationYear;
    private String author;
    private String publisher;


}
