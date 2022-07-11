package com.example.themaplreable.service;


import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;

import java.util.List;

/**
 * Service interface for the products.
 */
public interface ProductService {

    /**
     * Get all catalogue's product (with optional filter : type)
     */
    List<ProductDto> getCatalogue(String type) throws TypeNotExistException;

    /**
     * Get one product by productId
     */
    ProductDto getProductInfo(Long productId) throws ProductNotFoundException;
}
