package com.example.themaplreable.service;


import com.example.themaplreable.dto.CartLineDto;
import org.apache.catalina.connector.Response;

import java.util.List;

/**
 * Service interface for the Cart.
 */
public interface CartServiceInterface {

    /**
     * Get all cart lines
     */
    List<CartLineDto> getCart();

    /**
     * Add a product to cart (with a productId)
     */
    Response addToCart(String productId);

    /**
     * Remove a product from cart (with a productId)
     */
    Response removeFromCart(String productId);

    /**
     * Remove a product from cart (with a productId)
     */
    Response changeQty(String productId, Long newQty);
}
