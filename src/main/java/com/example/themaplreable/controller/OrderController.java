package com.example.themaplreable.controller;

import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Order Controller.
 */
@Controller()
@RequestMapping(
        value = "/orderLine",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class OrderController {

    OrderLineService orderService;

    /**
     * Constructor
     */
    @Autowired
    public OrderController(OrderLineService orderService) {
        this.orderService = orderService;
    }

    /**
     * Get all order lines
     *
     * @return List<OrderLineDto>
     */
    @GetMapping("/all")
    public ResponseEntity<List<OrderLineDto>> getOrder() {
        return ResponseEntity.ok().body(this.orderService.getOrderLines());
    }

    /**
     * Validate the the cart to become a real order
     *
     * @return OrderValidationResponseDto
     */
    @PostMapping("/validate")
    public String placeOrder(Model model) throws ProductNotFoundException {
        OrderValidationResponseDto orderValidation = this.orderService.placeOrder();
        model.addAttribute("orderValidation", orderValidation);
        return "orderValidate";
    }
}
