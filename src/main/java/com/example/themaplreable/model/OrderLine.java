package com.example.themaplreable.model;

import lombok.*;

import javax.persistence.*;

/**
 * Order Line DTO.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "QTY", nullable = false)
    private Long qty;

 /*   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product productId;*/
}
