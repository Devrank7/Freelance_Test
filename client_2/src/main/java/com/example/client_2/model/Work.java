package com.example.client_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work")
@Getter
@Setter
@NoArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int popular;
    @Column
    private String country;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "work_employee",joinColumns =
    @JoinColumn(name = "work_id"),inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    public Work(String name, int popular, String country, List<Employee> employees) {
        this.name = name;
        this.popular = popular;
        this.country = country;
        this.employees = employees;
    }
}
