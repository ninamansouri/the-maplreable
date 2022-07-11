package com.example.themaplreable.controller;

import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductDto>> getCatalogue(@PathVariable(name="type", required = false) String type) throws TypeNotExistException {
        return ResponseEntity.ok().body(productsService.getCatalogue(type));
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductInfo(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productsService.getProductInfo(productId));
    }
}
