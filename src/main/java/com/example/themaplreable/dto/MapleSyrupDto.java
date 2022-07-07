package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import com.example.themaplreable.model.enums.Type;

/**
 * Maple Syrup DTO.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapleSyrupDto {
    private String id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Long stock;
    private Type type;
}
