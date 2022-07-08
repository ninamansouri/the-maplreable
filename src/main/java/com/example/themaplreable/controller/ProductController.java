package com.example.themaplreable.controller;

import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Products Controller.
 */
@RestController()
@RequestMapping("/product")
public class ProductController {
    private final ProductService productsService;


    /**
     * Constructor
     */
    @Autowired
    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<ProductDto>
     */
    @GetMapping(value = {"/all", "/all/{type}"})
    public List<ProductDto> getCatalogue(@PathVariable(name="type", required = false) String type) {
        return productsService.getCatalogue(type);
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    @GetMapping("/{productId}")
    public ProductDto getProductInfo(@PathVariable("productId") Long productId) {
        return productsService.getProductInfo(productId);
    }
}
