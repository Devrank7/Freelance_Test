package com.example.client_1.model;

import com.example.client_1.model.role.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "userf")
@NoArgsConstructor
@Getter
@Setter
public class BUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    @Size(min = 2,max = 20,message = "the name should be 2 from 20 chars")
    @NotEmpty(message = "is Empty blank")
    private String name;
    @Column
    @Size(min = 2,max = 30,message = "the surname should be 2 from 30 chars")
    @NotEmpty(message = "is Empty blank")
    private String surname;
    @Column
    @Email(message = "Must be email string here")
    @NotEmpty(message = "is Empty blank")
    private String email;
    @Column
    @Size(min = 2,max = 157,message = "the password must be contain the more 2 chars")
    @NotEmpty(message = "is Empty blank")
    private String password;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @Column
    private int currency;
    @Column
    private Boolean isActive = Boolean.TRUE;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "owner")
    private List<BHotel> hotel = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "bookers")
    private List<BHotel> hotels = new ArrayList<>();
    @Column
    private String description;

    public BUser(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    @PrePersist
    public void dates() {
        date = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.name().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    @Override
    public String toString() {
        return "BUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", roles=" + roles +
                ", currency=" + currency +
                ", isActive=" + isActive +
                ", hotel=" + hotel +
                ", hotels=" + hotels +
                '}';
    }
    public boolean isAdmin() {
        return roles == Roles.ADMIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BUser bUser = (BUser) o;
        return id == bUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
