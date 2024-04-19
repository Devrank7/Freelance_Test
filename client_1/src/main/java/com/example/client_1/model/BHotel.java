package com.example.client_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "disc",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("null")
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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_book",
            joinColumns = @JoinColumn(name = "booker_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<BUser> bookers = new ArrayList<>();

    public BHotel(String name, byte grate, int price, String img, BUser owner) {
        this.name = name;
        this.grate = grate;
        this.price = price;
        this.img = img;
        this.owner = owner;
    }
    @Override
    public String toString() {
        return "[ -id = " + id + "\n" + " -name = " + name + "\n" + " -grate = " + grate + "\n" +
        " -price = " + price + " ]";
    }
}
