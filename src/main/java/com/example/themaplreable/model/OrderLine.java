package com.example.themaplreable.model;

import lombok.*;

import javax.persistence.*;

/**
 * Order Line Entity.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QTY", nullable = false)
    private Long qty;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product productId;
}
