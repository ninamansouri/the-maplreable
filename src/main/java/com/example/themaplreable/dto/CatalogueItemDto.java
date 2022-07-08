package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import com.example.themaplreable.model.enums.Type;

/**
 * Catalogue Item DTO.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogueItemDto {

    private String id;

    private String name;

    private String image;

    private Double price;

    private Long maxQty;

    private Type type;
}
