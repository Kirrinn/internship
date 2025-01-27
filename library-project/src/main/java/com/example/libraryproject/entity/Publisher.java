package com.example.libraryproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder //test

@Table(name = "publisher")


public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    List<Book> books;
}
