package com.example.themaplreable.service;


import com.example.themaplreable.dto.ProductDto;

import java.util.List;

/**
 * Service interface for the products.
 */
public interface ProductService {

    /**
     * Get all catalogue's product (with optional filter : type)
     */
    List<ProductDto> getCatalogue(String type);

    /**
     * Get one product by productId
     */
    ProductDto getProductInfo(Long productId);
}
