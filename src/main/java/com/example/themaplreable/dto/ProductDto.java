package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.themaplreable.model.enums.Type;
import lombok.NoArgsConstructor;

/**
 * Maple Syrup DTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private String id;

    private String name;

    private String description;

    private String image;

    private Double price;

    private Long stock;

    private Type type;
}
