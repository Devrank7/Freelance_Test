package com.example.client_2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "uproject")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String company;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "project")
    private List<Employee> employees = new ArrayList<>();

    public Project(String name, int price, String company, List<Employee> employees) {
        this.name = name;
        this.price = price;
        this.company = company;
        this.employees = employees;
    }

    public Project setId(int id) {
        this.id = id;
        return this;
    }
}
