package com.example.client_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;
    @Column
    private int power;
    @Column
    private int price;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;

    public Car(String model, int power, int price, Employee employee) {
        this.model = model;
        this.power = power;
        this.price = price;
        this.employee = employee;
    }
}
