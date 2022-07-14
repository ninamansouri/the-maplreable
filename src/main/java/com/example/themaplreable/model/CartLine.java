package com.example.themaplreable.model;


import lombok.*;

import javax.persistence.*;

/**
 * Cart Line Entity.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CART_LINE")
public class CartLine {
    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column (name = "NAME", nullable = false)
    private String name;

    @Column (name = "IMAGE", nullable = false)
    private String image;

    @Column (name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "QTY", nullable = false)
    private Long qty;

/*    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product productId;*/
}
