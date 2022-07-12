package com.example.themaplreable.service;


import com.example.themaplreable.converters.CartLineConverter;
import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.exception.CartLineNotFoundException;
import com.example.themaplreable.exception.EndOfStockException;
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
    public CartLineDto addToCart(Long productId, Long qty) throws ProductNotFoundException, EndOfStockException {
        var newCartLine = new CartLine();
        var product = this.productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        // Check if there is enough product
        var newStock = product.getStock() - qty;
        if (newStock < 0) {
            throw new EndOfStockException(product.getName());
        }

        // Set data of the new line
       // newCartLine.setId(7L);
        newCartLine.setName(product.getName());
        newCartLine.setImage(product.getImage());
        newCartLine.setPrice(product.getPrice() * qty);
        newCartLine.setQty(qty);
        newCartLine.setProductId(product);

        // update the product stock
        product.setStock(newStock);

        // save changes
        this.productRepository.save(product);
        this.cartLineRepository.save(newCartLine);
        return CartLineConverter.entityToDto(newCartLine);
    }

    /**
     * Remove a product from cart (with a productId)
     *
     * @param productId productId
     */
    @Override
    public boolean removeFromCart(Long productId) {
        var cartLine = this.cartLineRepository.findByProductId(productId);
        if (cartLine == null) {
            return false;
        } else {
            this.cartLineRepository.delete(cartLine);

            // update product datas
            Product productOfLine = cartLine.getProductId();
            productOfLine.setStock(productOfLine.getStock() + cartLine.getQty());
            this.productRepository.save(productOfLine);
            return true;
        }
    }

    /**
     * Change the quantity of one product in cart
     *
     * @param cartId cartId
     *               newQty
     * @return MapleSyrupDto
     */
    @Override
    public CartLineDto changeQty(Long cartId, Long newQty) throws CartLineNotFoundException {
        var newCartPrice = 0.00;
        var cartLine = this.cartLineRepository.findById(cartId).orElse(null);
        if (cartLine == null) {
            throw new CartLineNotFoundException();
        }

        // Update product stock
        Product productOfLine = cartLine.getProductId();
        var updatedStock = (productOfLine.getStock() + cartLine.getQty()) - newQty;
        productOfLine.setStock(updatedStock);

        // Calcul the new line price
        newCartPrice = cartLine.getProductId().getPrice() * newQty;
        cartLine.setPrice(newCartPrice);
        cartLine.setQty(newQty);

        // save changes
        this.productRepository.save(productOfLine);
        this.cartLineRepository.save(cartLine);
        return CartLineConverter.entityToDto(cartLine);
    }

}
