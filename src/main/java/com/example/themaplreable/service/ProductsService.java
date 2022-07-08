package com.example.themaplreable.service;


import com.example.themaplreable.dto.CatalogueItemDto;
import com.example.themaplreable.dto.MapleSyrupDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the ProductsService interface.
 */
@Service
@Transactional
public class ProductsService implements  ProductsServiceInterface {

    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<CatalogueItemDto>
     */
    @Override
    public List<CatalogueItemDto> getCatalogue(String type) {
        return null;
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return MapleSyrupDto
     */
    @Override
    public MapleSyrupDto getProductInfo(String productId) {
        return null;
    }
}
