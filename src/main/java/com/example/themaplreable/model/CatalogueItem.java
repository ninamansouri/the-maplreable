package com.example.themaplreable.model;

import com.example.themaplreable.model.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Catalogue Item Entity.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "catalogue_item")
public class CatalogueItem {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "maxQty", nullable = false)
    private Long maxQty;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;
}
