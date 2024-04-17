package com.example.client_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class BHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private byte grate; //min 0 max 100
    @Column
    private int price;
    @Column
    private String img;
    @ManyToOne
    @JoinColumn
    private BUser owner;

    public BHotel(String name, byte grate,int price, String img, BUser owner) {
        this.name = name;
        this.grate = grate;
        this.price = price;
        this.img = img;
        this.owner = owner;
    }
}
