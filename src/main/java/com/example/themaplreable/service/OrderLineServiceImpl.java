package com.example.themaplreable.service;


import com.example.themaplreable.converters.OrderLineConverter;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.OrderLine;
import com.example.themaplreable.repositories.CartLineRepository;
import com.example.themaplreable.repositories.OrderLineRepository;
import com.example.themaplreable.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the OrderService interface.
 */
@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

    OrderLineRepository orderLineRepository;

    CartLineRepository cartLineRepository;

    CartLineService cartLineService;

    /**
     * Constructor
     */
    @Autowired
    public OrderLineServiceImpl(OrderLineRepository orderLineRepository, CartLineRepository cartLineRepository, CartLineService cartLineService) {
        this.orderLineRepository = orderLineRepository;
        this.cartLineRepository = cartLineRepository;
        this.cartLineService = cartLineService;
    }

    /**
     * Get all order lines
     *
     * @return List<OrderLineDto>
     */
    @Override
    public List<OrderLineDto> getOrderLines() {
        return OrderLineConverter.entitiesToDtos(this.orderLineRepository.findAll());
    }

    /**
     * Validate the the cart to become a real order line
     *
     * @return OrderValidationResponseDto
     */
    @Override
    public OrderValidationResponseDto placeOrder() {
        OrderValidationResponseDto orderValidation = new OrderValidationResponseDto();
        List<CartLine> cartLines = this.cartLineRepository.findAll();

        if(cartLines.isEmpty()) {
            orderValidation.setOrderValid(false);
            orderValidation.setError("You can't validate an empty cart");
        }
        else {
            for (CartLine cartLine : cartLines) {
                OrderLine orderLine = new OrderLine();
                orderLine.setQty(cartLine.getQty());
                orderLine.setProductId(cartLine.getProductId());
                this.orderLineRepository.save(orderLine);

                // Remove the validate line from cart
                this.cartLineService.removeFromCart(cartLine.getProductId().getId());
            }
            orderValidation.setOrderValid(true);
        }

        return orderValidation;
    }
}
