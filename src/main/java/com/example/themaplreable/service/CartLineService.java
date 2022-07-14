package com.example.themaplreable.service;


import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.ProductNotFoundException;

import java.util.List;

/**
 * Service interface for the Cart.
 */
public interface CartLineService {

    /**
     * Get all cart lines
     */
    List<CartLineDto> getCartLines();

    /**
     * Add a product to cart (with a productId)
     */
    CartLineDto addToCart(String productId, Long qty) throws ProductNotFoundException;

    /**
     * Remove all cart
     */
    void removeAllCart();

    /**
     * Remove a product from cart (with a productId)
     */
    boolean removeFromCart(String productId);

    /**
     * Change the quantity of one product in cart
     */
    CartLineDto changeQty(String productId, Long newQty) throws CartLineNotFoundException, ProductNotFoundException;
}
