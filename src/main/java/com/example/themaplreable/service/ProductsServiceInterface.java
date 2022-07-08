package com.example.themaplreable.service;


import com.example.themaplreable.dto.CatalogueItemDto;
import com.example.themaplreable.dto.MapleSyrupDto;

import java.util.List;

/**
 * Service interface for the products.
 */
public interface ProductsServiceInterface {

    /**
     * Get all catalogue's product (with optional filter : type)
     */
    List<CatalogueItemDto> getCatalogue(String type);

    /**
     * Get one product by productId
     */
    MapleSyrupDto getProductInfo(String productId);
}
