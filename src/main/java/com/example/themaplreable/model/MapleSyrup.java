package com.example.themaplreable.model;

import com.example.themaplreable.model.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Maple Syrup Entity.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "maple_syrup")
public class MapleSyrup {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;
}
