package com.example.themaplreable.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Order Validation Response DTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderValidationResponseDto {

    private boolean isOrderValid;

    private String error;

    private List<OrderLineDto> orderLines;

}
