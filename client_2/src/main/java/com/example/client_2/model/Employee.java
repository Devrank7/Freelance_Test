package com.example.client_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int salary;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    private List<Car> cars = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employees")
    private List<Work> works = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    private House house;
    @ManyToOne
    @JoinColumn(name = "proj_id")
    @JsonIgnore
    private Project project;

    public Employee(String name, String lastname, int salary) {
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
    }
}
