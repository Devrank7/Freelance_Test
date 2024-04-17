package com.example.client_1.model;

import com.example.client_1.model.role.Direction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "2")
public class BItem extends BHotel {
    @Column
    private int durability;

    @Column
    private int weight;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    @Column
    private String description;

    public BItem(String name, byte grate, int price, String img, BUser owner, int durability, int weight, Direction direction, String description) {
        super(name, grate, price, img, owner);
        this.durability = durability;
        this.weight = weight;
        this.direction = direction;
        this.description = description;
    }
}
