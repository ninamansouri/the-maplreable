package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Order Line DTO.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineDto {

    private Long id;

    private String productId;

    private Long qty;
}
