package com.example.themaplreable.controller;

import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Order Controller.
 */
@RestController()
@RequestMapping("/order")
public class OrderController {

    /**
     * Constructor
     */
    @Autowired
    public OrderController() {
    }

    /**
     * ??????
     *
     * @param orderLines orderLines
     * @return OrderValidationResponseDto
     */
    @PostMapping("/")
    public OrderValidationResponseDto placeOrder(@RequestBody List<OrderLineDto> orderLines) {
        return null;
    }
}
