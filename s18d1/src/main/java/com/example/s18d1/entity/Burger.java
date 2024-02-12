package com.example.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "burger", schema = "fsweb")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Column(name = "bread_type")
    private Bread breadType;

    @Column(name = "contents")
    private String contents;
}
