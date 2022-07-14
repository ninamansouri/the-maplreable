package com.example.themaplreable.service;


import com.example.themaplreable.converters.CartLineConverter;
import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.Product;
import com.example.themaplreable.repositories.CartLineRepository;
import com.example.themaplreable.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the CartService interface.
 */
@Service
@Transactional
public class CartLineServiceImpl implements CartLineService {

    CartLineRepository cartLineRepository;

    ProductRepository productRepository;

    /**
     * Constructor
     */
    @Autowired
    public CartLineServiceImpl(CartLineRepository cartLineRepository, ProductRepository productRepository) {
        this.cartLineRepository = cartLineRepository;
        this.productRepository = productRepository;
    }

    /**
     * Get all cart lines
     *
     * @return List<CartLineDto>
     */
    @Override
    public List<CartLineDto> getCartLines() {
        return CartLineConverter.entitiesToDtos(this.cartLineRepository.findAll());
    }

    /**
     * Add a product to cart (with a productId)
     *
     * @param productId productId
     *                  qty
     * @return Response
     */
    @Override
    public CartLineDto addToCart(String productId, Long qty) throws ProductNotFoundException {
        var newCartLine = new CartLine();
        var product = this.productRepository.findById(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        // Set data of the new line
        newCartLine.setProductId(productId);
        newCartLine.setName(product.getName());
        newCartLine.setImage(product.getImage());
        newCartLine.setPrice(product.getPrice() * qty);
        newCartLine.setQty(qty);
        this.cartLineRepository.save(newCartLine);

        return CartLineConverter.entityToDto(newCartLine);
    }

    /**
     * Remove all cart
     */
    @Override
    public void removeAllCart() {
        List<CartLine> cartLines = this.cartLineRepository.findAll();
        this.cartLineRepository.deleteAll(cartLines);
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     */
    @Override
    public boolean removeFromCart(String productId) {
        var cartLine = this.cartLineRepository.findByProductId(productId);
        if (cartLine == null) {
            return false;
        } else {
            this.cartLineRepository.delete(cartLine);
            return true;
        }
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param productId productId
     *                  newQty
     * @return MapleSyrupDto
     */
    @Override
    public CartLineDto changeQty(String productId, Long newQty) throws CartLineNotFoundException, ProductNotFoundException {
        var newCartPrice = 0.00;
        var cartLine = this.cartLineRepository.findByProductId(productId);
        if (cartLine == null) {
            throw new CartLineNotFoundException();
        }

        var product = this.productRepository.findById(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        // Calcul the new line price
        newCartPrice = product.getPrice() * newQty;
        cartLine.setPrice(newCartPrice);
        cartLine.setQty(newQty);
        this.cartLineRepository.save(cartLine);

        return CartLineConverter.entityToDto(cartLine);
    }

}
