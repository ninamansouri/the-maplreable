package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Order Controller.
 */
@RestController()
@RequestMapping(
        value = "/orderLine",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class OrderLineController {

    OrderLineService orderService;

    /**
     * Constructor
     */
    @Autowired
    public OrderLineController(OrderLineService orderService) {
        this.orderService = orderService;
    }

    /**
     * Get all order lines
     *
     * @return List<OrderLineDto>
     */
    @GetMapping("/all")
    public ResponseEntity<List<OrderLineDto>> getCart() {
        return ResponseEntity.ok().body(this.orderService.getOrderLines());
    }

    /**
     * Validate the the cart to become a real order line
     *
     * @return OrderValidationResponseDto
     */
    @PostMapping("/validate")
    public ResponseEntity<OrderValidationResponseDto> placeOrder() {
        return ResponseEntity.ok(this.orderService.placeOrder());
    }
}
