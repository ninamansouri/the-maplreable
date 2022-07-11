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
@RequestMapping(
        value = "/order",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class OrderLineController {

    /**
     * Constructor
     */
    @Autowired
    public OrderLineController() {
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
