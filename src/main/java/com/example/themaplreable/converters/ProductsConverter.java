package com.example.themaplreable.converters;

import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.model.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * Maple Syrup Converter.
 */
public class ProductsConverter {

    /**
     * Convert Product to ProductDto.
     */
    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        if (product != null) {
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDto.setStock(product.getStock());
            productDto.setType(product.getType());
        }


        return productDto;
    }

    /**
     * Convert ProductDto to Product.
     */
    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        if (productDto != null) {
            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setImage(productDto.getImage());
            product.setPrice(productDto.getPrice());
            product.setStock(productDto.getStock());
            product.setType(productDto.getType());
        }

        return product;
    }

    /**
     * Convert List<Product> to List<ProductDto>.
     */
    public static List<ProductDto> entitiesToDtos(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            productDtos.add(entityToDto(product));
        }

        return productDtos;
    }
}
