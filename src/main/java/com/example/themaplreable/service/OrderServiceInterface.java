package com.example.themaplreable.service;


import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;

import java.util.List;

/**
 * Service interface for the Order.
 */
public interface OrderServiceInterface {

    /**
     * ??????
     */
    OrderValidationResponseDto placeOrder(List<OrderLineDto> orderLines);

}
