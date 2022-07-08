package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Order Validation Response DTO.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderValidationResponseDto {

    private boolean isOrderValid;

    private String error;

}
