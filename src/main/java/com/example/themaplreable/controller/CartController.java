package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Cart Controller.
 */
@Controller()
@RequestMapping(
        value = "/cartLine",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class CartController {

    CartLineService cartService;

    /**
     * Constructor
     */
    @Autowired
    public CartController(CartLineService cartService) {
        this.cartService = cartService;
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @GetMapping("/all")
    public String getCartLines(Model model) {
        List<CartLineDto> cartLineList = this.cartService.getCartLines();
        model.addAttribute("cartLineList", cartLineList);
        return "cartPage";
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @PutMapping("/add/{productId}/{qty}")
    public ResponseEntity<CartLineDto> addToCart(@PathVariable String productId, @PathVariable Long qty) throws ProductNotFoundException {
        return ResponseEntity.ok(this.cartService.addToCart(productId, qty));
    }

    /**
     * Remove allcart (with a productId)
     */
    @DeleteMapping("/remove/all")
    public void removeAllCart() {
       this.cartService.removeAllCart();
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     * @return Response
     */
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromCart(@PathVariable String productId) throws CartLineNotFoundException {
        var isRemoved = this.cartService.removeFromCart(productId);
        if (!isRemoved) {
            throw new CartLineNotFoundException();
        }
        return new ResponseEntity<>("The product " + productId + " is remove successfully", HttpStatus.OK);
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param productId productId
     *                  newQty
     * @return MapleSyrupDto
     */
    @PatchMapping("/change/{productId}/{newQty}")
    public ResponseEntity<CartLineDto> changeQty(@PathVariable String productId, @PathVariable Long newQty) throws CartLineNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(this.cartService.changeQty(productId, newQty));
    }

}
