package com.example.client_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String writer;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Library library;

    public Book(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }
}
