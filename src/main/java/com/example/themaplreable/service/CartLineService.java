package com.example.themaplreable.service;


import com.example.themaplreable.converters.CartLineConverter;
import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.repositories.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the CartService interface.
 */
@Service
@Transactional
public class CartLineService {

    CartLineRepository cartLineRepository;

    ProductsService productsService;


    @Autowired
    public CartLineService(CartLineRepository cartLineRepository, ProductsService productsService) {
        this.cartLineRepository = cartLineRepository;
        this.productsService = productsService;
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    public List<CartLineDto> getCartLines() {
        return CartLineConverter.entitiesToDtos(this.cartLineRepository.findAll());
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     *                  qty
     */
    public CartLineDto addToCart(String productId) throws ProductNotFoundException, CartLineNotFoundException {
        var newCartLine = new CartLine();
        var product = this.productsService.getProductInfo(productId);

        // Check if the product it's already in the cart
        var cartLine = this.cartLineRepository.findByProductId(productId).orElse(null);
        if (cartLine == null) {
            newCartLine.setProductId(productId);
            newCartLine.setName(product.getName());
            newCartLine.setImage(product.getImage());
            newCartLine.setPrice(product.getPrice());
            newCartLine.setQty(1L);

            this.cartLineRepository.save(newCartLine);
            return CartLineConverter.entityToDto(newCartLine);
        } else {
            cartLine.setPrice(cartLine.getPrice() + product.getPrice());
            cartLine.setQty(cartLine.getQty() + 1);

            this.cartLineRepository.save(cartLine);
            return CartLineConverter.entityToDto(cartLine);
        }
    }

    /**
     * Remove all cart
     */
    public void removeAllCart() {
        List<CartLine> cartLines = this.cartLineRepository.findAll();
        this.cartLineRepository.deleteAll(cartLines);
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     */
    public void removeFromCart(String productId) throws CartLineNotFoundException {
        var cartLine = this.cartLineRepository.findByProductId(productId)
                .orElseThrow(CartLineNotFoundException::new);
        this.cartLineRepository.delete(cartLine);
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param productId productId
     *                  newQty
     * @return MapleSyrupDto
     */
    public CartLineDto changeQty(String productId, Long newQty) throws CartLineNotFoundException, ProductNotFoundException {
        var cartLine = this.cartLineRepository.findByProductId(productId)
                .orElseThrow(CartLineNotFoundException::new);
        var product = this.productsService.getProductInfo(productId);

        // Calcul the new line price
        cartLine.setPrice(product.getPrice() * newQty);
        cartLine.setQty(newQty);
        this.cartLineRepository.save(cartLine);

        return CartLineConverter.entityToDto(cartLine);
    }

}
