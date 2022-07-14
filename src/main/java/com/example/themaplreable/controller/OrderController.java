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
@Controller
@RequestMapping("/order")
public class OrderController {

    OrderLineService orderService;


    @Autowired
    public OrderController(OrderLineService orderService) {
        this.orderService = orderService;
    }

    /**
     * Get all order lines
     *
     * @return ResponseEntity<List<OrderLineDto>>
     */
    @GetMapping("/all")
    public ResponseEntity<List<OrderLineDto>> getOrder() {
        return ResponseEntity.ok().body(this.orderService.getOrderLines());
    }

    /**
     * Validate the the cart to become a real order
     *
     * @return ResponseEntity<OrderValidationResponseDto>
     */
    @PostMapping("/")
    public ResponseEntity<OrderValidationResponseDto> placeOrder(Model model) throws ProductNotFoundException {
       /* OrderValidationResponseDto orderValidation = this.orderService.placeOrder();
        model.addAttribute("orderValidation", orderValidation);
        return "orderValidate";*/

        return ResponseEntity.ok().body(this.orderService.placeOrder());
    }
}
