package com.example.themaplreable.model;

import com.example.themaplreable.model.enums.Type;
import lombok.*;

import javax.persistence.*;

/**
 * Product Entity.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "IMAGE", nullable = false)
    private String image;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "STOCK", nullable = false)
    private Long stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private Type type;

}
