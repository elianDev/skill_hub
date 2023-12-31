package com.example.SkillHub.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
