package com.example.themaplreable.service;


import com.example.themaplreable.converters.ProductConverter;
import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.model.Product;
import com.example.themaplreable.model.enums.Type;
import com.example.themaplreable.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<ProductDto> getCatalogue(String type) throws TypeNotExistException {
        List<ProductDto> productDtos = new ArrayList<>();
        if (type == null) {
            productDtos.addAll(ProductConverter.entitiesToDtos(this.productRepository.findAll()));
        } else {
            if(asMyEnum(type) == null) {
                throw new TypeNotExistException(type);
            }
            var typeEnum = Type.valueOf(type);
            productDtos.addAll(ProductConverter.entitiesToDtos(this.productRepository.findByType(typeEnum)));
        }
        return productDtos;
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    @Override
    public ProductDto getProductInfo(Long productId) throws ProductNotFoundException {
        var product = this.productRepository.findById(productId).orElse(null);
        if(product == null) {
            throw new ProductNotFoundException(productId);
        }
        
        return ProductConverter.entityToDto(product);
    }

    /**
     * Check if the string exist into the enum
     *
     * @param typeSelected typeSelected
     * @return Type
     */
    private static Type asMyEnum(String typeSelected) {
        for (Type typeEnum : Type.values()) {
            if (typeEnum.name().equalsIgnoreCase(typeSelected))
                return typeEnum;
        }
        return null;
    }
}
