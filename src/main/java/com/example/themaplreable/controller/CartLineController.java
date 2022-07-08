package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Cart Controller.
 */
@RestController()
@RequestMapping("/cart")
public class CartLineController {

    /**
     * Constructor
     */
    @Autowired
    public CartLineController() {
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @GetMapping("/")
    public List<CartLineDto> getCart() {
        return null;
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @PutMapping("/add/{productId}")
    public Response addToCart(@PathVariable("productId") String productId) {
        return null;
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @DeleteMapping("/delete/{productId}")
    public Response removeFromCart(@PathVariable("productId") String productId) {
        return null;
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     *                  newQty
     * @return MapleSyrupDto
     */
    @PatchMapping("/delete/{productId}")
    public Response changeQty(@PathVariable("productId") String productId, Long newQty) {
        return null;
    }

}
