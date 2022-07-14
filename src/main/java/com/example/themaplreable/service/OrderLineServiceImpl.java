package com.example.themaplreable.service;


import com.example.themaplreable.converters.OrderLineConverter;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.dto.OrderValidationResponseDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.OrderLine;
import com.example.themaplreable.model.Product;
import com.example.themaplreable.repositories.CartLineRepository;
import com.example.themaplreable.repositories.OrderLineRepository;
import com.example.themaplreable.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for the OrderService interface.
 */
@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

    OrderLineRepository orderLineRepository;

    CartLineRepository cartLineRepository;

    ProductRepository productRepository;

    CartLineService cartLineService;

    /**
     * Constructor
     */
    @Autowired
    public OrderLineServiceImpl(OrderLineRepository orderLineRepository, CartLineRepository cartLineRepository, ProductRepository productRepository, CartLineService cartLineService) {
        this.orderLineRepository = orderLineRepository;
        this.cartLineRepository = cartLineRepository;
        this.productRepository = productRepository;
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
     * Validate the the cart to become a real order
     *
     * @return OrderValidationResponseDto
     */
    @Override
    public OrderValidationResponseDto placeOrder() throws ProductNotFoundException {
        List<OrderLine> orderLines = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> idProductList = new ArrayList<>();

        var orderValidation = new OrderValidationResponseDto();
        orderValidation.setOrderValid(true);
        List<CartLine> cartLines = this.cartLineRepository.findAll();

        if(cartLines.isEmpty()) {
            orderValidation.setOrderValid(false);
            orderValidation.setError("You can't validate an empty cart !");
        }
        else {
            for (CartLine cartLine : cartLines) {
                var orderLine = new OrderLine();
                var product = this.productRepository.findById(cartLine.getProductId());

                if (product == null) {
                    throw new ProductNotFoundException(cartLine.getProductId());
                }

                // Check if there is enough stock
                var remainingStock = product.getStock() - cartLine.getQty();
                if (remainingStock < 0) {
                    orderValidation.setOrderValid(false);
                    idProductList.add(cartLine.getProductId());
                }
                else {
                    orderLine.setQty(cartLine.getQty());
                    orderLine.setProductId(cartLine.getProductId());
                    orderLines.add(orderLine);

                    // update the product stock
                    product.setStock(remainingStock);
                    products.add(product);
                }
            }

            if (orderValidation.isOrderValid()) {
                // save changes
                this.productRepository.saveAll(products);
                this.orderLineRepository.saveAll(orderLines);

                // Remove the cart
                this.cartLineService.removeAllCart();

                orderValidation.setOrderLines(new ArrayList<>());
                orderValidation.getOrderLines().addAll(OrderLineConverter.entitiesToDtos(orderLines));
            }
            else {
                orderValidation.setError("There is no enough stock for the product(s) : " + idProductList);
            }
        }

        return orderValidation;
    }
}
