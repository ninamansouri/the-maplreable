package com.example.themaplreable.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Order Line DTO.
 */
@Getter
@Setter
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLine {
    private Long id;
    private String productId;
    private Long qty;
}
