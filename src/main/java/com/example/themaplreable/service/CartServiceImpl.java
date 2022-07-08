package com.example.themaplreable.service;


import com.example.themaplreable.dto.CartLineDto;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the CartService interface.
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @Override
    public List<CartLineDto> getCart() {
        return null;
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @Override
    public Response addToCart(String productId) {
        return null;
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @Override
    public Response removeFromCart(String productId) {
        return null;
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     *                  newQty
     * @return MapleSyrupDto
     */
    @Override
    public Response changeQty(String productId, Long newQty) {
        return null;
    }

}
