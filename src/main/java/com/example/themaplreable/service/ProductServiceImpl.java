package com.example.themaplreable.service;


import com.example.themaplreable.converters.ProductConverter;
import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the ProductsService interface.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;


    /**
     * Constructor
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<ProductDto>
     */
    @Override
    public List<ProductDto> getCatalogue(String type) {
        if(type == null) {
            return ProductConverter.entitiesToDtos(this.productRepository.findAll());
        } else {
            return ProductConverter.entitiesToDtos(this.productRepository.findByType(type));
        }
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    @Override
    public ProductDto getProductInfo(Long productId) {
        return null;
        //return ProductConverter.entityToDto(this.productRepository.findById(productId).get(0));
    }
}
