package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Cart Controller.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    CartLineService cartService;


    @Autowired
    public CartController(CartLineService cartService) {
        this.cartService = cartService;
    }

    /**
     * Get all cart lines
     *
     * @return ResponseEntity<List<CartLineDto>>
     */
    @GetMapping("/")
    public ResponseEntity<List<CartLineDto>> getCartLines(Model model) {
        /*List<CartLineDto> cartLineList = this.cartService.getCartLines();
        model.addAttribute("cartLineList", cartLineList);
        return "cartPage";*/

        return ResponseEntity.ok().body(this.cartService.getCartLines());
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return ResponseEntity<CartLineDto>
     */
    @PutMapping("/{productId}")
    public ResponseEntity<CartLineDto> addToCart(String productId, Model model) throws ProductNotFoundException, CartLineNotFoundException {
       /* this.cartService.addToCart(productId);
        return "maplrErableHome";*/

        return ResponseEntity.ok().body(this.cartService.addToCart(productId));
    }

    /**
     * Remove all cart (with a productId)
     */
    @DeleteMapping("/remove/all")
    public void removeAllCart() {
        this.cartService.removeAllCart();
       // return "cartPage";
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     */
    @DeleteMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable String productId, Model model) throws CartLineNotFoundException {
        this.cartService.removeFromCart(productId);
        /*model.addAttribute("cartLineList", this.cartService.getCartLines());
        return "cartPage";*/
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param productId productId
     *                  newQty
     * @return ResponseEntity<CartLineDto>
     */
    @PatchMapping("/{productId}/{newQty}")
    public ResponseEntity<CartLineDto> changeQty(@PathVariable String productId, @PathVariable Long newQty) throws CartLineNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(this.cartService.changeQty(productId, newQty));
    }

}
