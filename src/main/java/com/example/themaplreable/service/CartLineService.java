package com.example.themaplreable.service;


import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.EndOfStockException;
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
    CartLineDto addToCart(Long productId, Long qty) throws ProductNotFoundException, EndOfStockException;

    /**
     * Remove a product from cart (with a productId)
     */
    boolean removeFromCart(Long productId);

    /**
     * Change the quantity of one product in cart
     */
    CartLineDto changeQty(Long cartId, Long newQty) throws CartLineNotFoundException;
}
