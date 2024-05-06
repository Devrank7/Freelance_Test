package com.example.client_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usr_id_table")
@Data
@NoArgsConstructor
public class User_ID {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int usr_id;

    public User_ID(int usr_id) {
        this.usr_id = usr_id;
    }
}
