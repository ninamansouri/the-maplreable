package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Cart Line DTO.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartLineDto {
    private Long id;
    private String productId;
    private String name;
    private String image;
    private Double price;
    private Long qty;
}
