package com.example.themaplreable.service;


import com.example.themaplreable.converters.ProductsConverter;
import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.model.enums.Type;
import com.example.themaplreable.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Implementation for the products action.
 */
@Service
@Transactional
public class ProductsService {

    ProductsRepository productRepository;


    @Autowired
    public ProductsService(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<ProductDto>
     */
    public List<ProductDto> getCatalogue(String type) throws TypeNotExistException {
        if (type != null) {
            if (asMyEnum(type) == null) {
                throw new TypeNotExistException(type);
            }
            return ProductsConverter.entitiesToDtos(this.productRepository.findByType(Type.valueOf(type)));
        }

        return ProductsConverter.entitiesToDtos(this.productRepository.findAll());
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    public ProductDto getProductInfo(String productId) throws ProductNotFoundException {
        var product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        return ProductsConverter.entityToDto(product);
    }

    /**
     * Update the stock of one product
     *
     * @param productId productId
     */
    public void updateStock(String productId, Long newStock) throws ProductNotFoundException {
        var product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        product.setStock(newStock);
        this.productRepository.save(product);
    }

    /**
     * Check if the string exist into the enum
     *
     * @param typeSelected typeSelected
     * @return Type
     */
    private static Type asMyEnum(String typeSelected) {
        return Arrays.stream(Type.values())
                .filter(type -> type.name().equalsIgnoreCase(typeSelected))
                .findFirst()
                .orElse(null);

    }


}
