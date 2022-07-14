package com.example.themaplreable.service;


import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.exception.ProductNotFoundException;

import java.util.List;


/**
 * Service interface for the Order.
 */
public interface OrderLineService {

    /**
     * Get all order lines
     */
    List<OrderLineDto> getOrderLines();

    /**
     * Validate the the cart to become a real order
     */
    OrderValidationResponseDto placeOrder() throws ProductNotFoundException;

}
