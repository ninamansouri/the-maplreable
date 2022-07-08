package com.example.themaplreable.controller;

import com.example.themaplreable.dto.CatalogueItemDto;
import com.example.themaplreable.dto.MapleSyrupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Products Controller.
 */
@RestController()
@RequestMapping("/products")
public class ProductsController {

    /**
     * Constructor
     */
    @Autowired
    public ProductsController() {
    }

    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<CatalogueItemDto>
     */
    @GetMapping("/all/{type}")
    public List<CatalogueItemDto> getCatalogue(@PathVariable("type") String type) {
        return null;
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return MapleSyrupDto
     */
    @GetMapping("/{productId}")
    public MapleSyrupDto getProductInfo(@PathVariable("productId") String productId) {
        return null;
    }
}
