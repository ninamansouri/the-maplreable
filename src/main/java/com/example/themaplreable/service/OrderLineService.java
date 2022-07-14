package com.example.themaplreable.service;


import com.example.themaplreable.converters.CartLineConverter;
import com.example.themaplreable.converters.OrderLineConverter;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.OrderLine;
import com.example.themaplreable.repositories.CartLineRepository;
import com.example.themaplreable.repositories.OrderLineRepository;
import com.example.themaplreable.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation for the orders actions
 */
@Service
@Transactional
public class OrderLineService {

    OrderLineRepository orderLineRepository;

    CartLineService cartLineService;

    ProductsService productsService;


    @Autowired
    public OrderLineService(OrderLineRepository orderLineRepository, CartLineService cartLineService, ProductsService productsService) {
        this.orderLineRepository = orderLineRepository;
        this.cartLineService = cartLineService;
        this.productsService = productsService;
    }

    /**
     * Get all order lines
     *
     * @return List<OrderLineDto>
     */
    public List<OrderLineDto> getOrderLines() {
        return OrderLineConverter.entitiesToDtos(this.orderLineRepository.findAll());
    }

    /**
     * Validate the the cart to become a real order
     *
     * @return OrderValidationResponseDto
     */
    public OrderValidationResponseDto placeOrder() throws ProductNotFoundException {
        /*List<CartLine> cartLines = CartLineConverter.dtosToEntites(this.cartLineService.getCartLines());

        if (cartLines.isEmpty()) {
            return new OrderValidationResponseDto(false, "You can't validate an empty cart !", Collections.emptyList());
        }

        var cartProductPairs = cartLines.stream()
                .map(cartLine ->
                        Pair.of(cartLine, this.productsService.getProductInfo(cartLine.getProductId()))
                ).toList();

        var errors = cartProductPairs.stream().filter(cartLineOptionalPair ->
                cartLineOptionalPair.getSecond().isEmpty() ||
                        cartLineOptionalPair.getSecond().get().getStock() < cartLineOptionalPair.getFirst().getQty()
        ).toList();

        if (!errors.isEmpty()) {
            var message = errors.stream()
                    .map(cartLineOptionalPair ->
                            "There is no enough stock for the product(s) :" + cartLineOptionalPair.getFirst().getProductId())
                    .collect(Collectors.joining(","));
            return new OrderValidationResponseDto(false, message, Collections.emptyList());
        }


        var orderLine = cartProductPairs.stream().peek(cartLineOptionalPair -> {
                    var updatedStock = cartLineOptionalPair.getSecond().get().getStock()
                            - cartLineOptionalPair.getFirst().getQty();
                    this.productsService.updateStock(cartLineOptionalPair.getSecond().get().getId(), updatedStock)
                    //cartLineOptionalPair.getSecond().get().setStock(updatedStock);
                })
                .map(cartLineOptionalPair ->
                        new OrderLine(cartLineOptionalPair.getFirst().getProductId(),
                                cartLineOptionalPair.getFirst().getQty())
                ).toList();

        this.orderLineRepository.saveAll(orderLine);

      *//*  this.productsService.updateStock(
                cartProductPairs.stream()
                        .map(cartLineOptionalPair -> cartLineOptionalPair.getSecond().get()).toList());*//*

        return new OrderValidationResponseDto(true, null, OrderLineConverter.entitiesToDtos(orderLine));
*/
        return null;
    }
}


