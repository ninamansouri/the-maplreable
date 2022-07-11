package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.EndOfStockException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Cart Controller.
 */
@RestController()
@RequestMapping("/cart")
public class CartLineController {

    CartService cartService;

    /**
     * Constructor
     */
    @Autowired
    public CartLineController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @GetMapping("/all")
    public ResponseEntity<List<CartLineDto>> getCart() {
        return ResponseEntity.ok().body(this.cartService.getCart());
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @PutMapping("/add/{productId}")
    public ResponseEntity<CartLineDto> addToCart(@PathVariable Long productId) throws ProductNotFoundException, EndOfStockException {
        return ResponseEntity.ok(this.cartService.addToCart(productId));
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Long> removeFromCart(@PathVariable Long productId) {
        var isRemoved = this.cartService.removeFromCart(productId);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param cartId cartId
     *               newQty
     * @return MapleSyrupDto
     */
    @PatchMapping("/change/{cartId}/{newQty}")
    public ResponseEntity<CartLineDto> changeQty(@PathVariable Long cartId, @PathVariable Long newQty) throws CartLineNotFoundException {
        return ResponseEntity.ok(this.cartService.changeQty(cartId, newQty));
    }

}
