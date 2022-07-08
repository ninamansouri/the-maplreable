package com.example.themaplreable.service;


import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the OrderService interface.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    /**
     * ??????
     *
     * @param orderLines orderLines
     * @return OrderValidationResponseDto
     */
    @Override
    public OrderValidationResponseDto placeOrder(List<OrderLineDto> orderLines) {
        return null;
    }
}
