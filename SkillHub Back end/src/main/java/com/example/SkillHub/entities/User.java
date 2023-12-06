package com.example.SkillHub.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthDate;

    @Column(unique = true)
    private String phone;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @OneToMany(mappedBy = "seller")
    private List<Advertising> advertisings = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
}
