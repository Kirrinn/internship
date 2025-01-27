package org.example.seviceb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookServiceBDto {
    private String title;
    private Integer publicationYear;
    private String author;
    private String publisher;
    private Integer isbn;
}
