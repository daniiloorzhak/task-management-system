package ru.oorzhak.taskmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Transient
    public static final Role ROLE_ADMIN = new Role(1L, "ROLE_ADMIN");
    @Transient
    public static final Role ROLE_USER = new Role(2L, "ROLE_USER");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
}
