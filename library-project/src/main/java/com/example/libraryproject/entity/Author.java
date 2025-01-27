package com.example.libraryproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "author")


public class Author {

    @Id
    //ovo mora da se doda za kolone koje su autoincrement da kazes koja je strategija
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;
//    private Integer year;

    @Column(name = "nationality")
    private String nationality;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books;
}
