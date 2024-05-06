package com.example.client_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_grade",
    joinColumns = @JoinColumn(name = "grade_id"))
    private List<BGrade> grades = new ArrayList<>();
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "usr_comment",
    joinColumns = @JoinColumn(name = "com_id"))
    private List<Comment> comments = new ArrayList<>();
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

    @Column(name = "m_desc")
    private String mainDescription;

    public BHotel(String name, byte grate, int price, String img, BUser owner) {
        this.name = name;
        this.grate = grate;
        this.price = price;
        this.img = img;
        this.owner = owner;
    }
    public BHotel(String name, byte grate, int price, String img) {
        this.name = name;
        this.grate = grate;
        this.price = price;
        this.img = img;
    }
    @Override
    public String toString() {
        return "[ -id = " + id + "\n" + " -name = " + name + "\n" + " -grate = " + grate + "\n" +
        " -price = " + price + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BHotel bHotel = (BHotel) o;
        return id == bHotel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public int gradeAvg() {
        if (!getGrades().isEmpty()) {
            int u = getGrades().stream().mapToInt(n -> n.getGrade()).sum() / getGrades().size();
            return u;
        }
        return 0;
    }

}
