package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.EndOfStockException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Cart Controller.
 */
@RestController()
@RequestMapping(
        value = "/cartLine",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class CartLineController {

    CartLineService cartService;

    /**
     * Constructor
     */
    @Autowired
    public CartLineController(CartLineService cartService) {
        this.cartService = cartService;
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @GetMapping("/all")
    public ResponseEntity<List<CartLineDto>> getCartLines() {
        return ResponseEntity.ok().body(this.cartService.getCartLines());
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @PutMapping("/add/{productId}/{qty}")
    public ResponseEntity<CartLineDto> addToCart(@PathVariable Long productId, @PathVariable Long qty) throws ProductNotFoundException, EndOfStockException {
        return ResponseEntity.ok(this.cartService.addToCart(productId, qty));
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long productId) throws CartLineNotFoundException {
        var isRemoved = this.cartService.removeFromCart(productId);
        if (!isRemoved) {
            throw new CartLineNotFoundException();
        }
        return new ResponseEntity<>("The product " + productId + " is remove successfully", HttpStatus.OK);
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
