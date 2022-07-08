package com.example.themaplreable.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/**
 * Cart Line Entity.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart_line")
public class CartLine {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "image", nullable = false)
    private String image;

    @Column (name = "price", nullable = false)
    private Double price;

    @Column(name = "qty", nullable = false)
    private Long qty;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product productId;
}
